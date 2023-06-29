package com.ssafy.codingtestServer.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Service {
    static String path = System.getProperty("user.dir") + "/src/main/java/com/ssafy/codingtestServer";
    static AtomicBoolean isTimeOver = new AtomicBoolean(false);

    public static ResponseEntity<Map<String, Object>> runCode(String code) throws IOException {

        try {
            // FileWriter를 사용하여 파일을 열고, BufferedWriter로 래핑합니다.
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/Main.java"));
            writer.write(code);
            writer.close();

            System.out.println("파일에 문자열을 썼습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        String error = "맞았습니다";
        try {
            compileJavaCode("/Main.java");
        } catch (IOException ioException) {
            error = "컴파일 빌드 에러";
            map.put("result", error);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }

        BufferedReader input = new BufferedReader(new FileReader(path + "/input.txt"));
        BufferedReader output = new BufferedReader(new FileReader(path + "/output.txt"));

        String in, out;

        while ((in = input.readLine()) != null && (out = output.readLine()) != null) {

            try {
                if (!executeJavaCode("Main", in, out)) {
                    error = "틀렸습니다";
                    break;
                }
                if (isTimeOver.get()) {
                    error = "시간 초과";
                }
            } catch (IOException ioException) {
                error = "runtimeError";
                break;
            } catch (TimeLimitExceededException timeLimitExceededException) {
                System.out.println("시간 초과");
                error = "시간 초과";
                break;
            } catch (InterruptedException interruptedException) {
                error = "틀렸습니다";
                break;
            }

        }

        map.put("result", error);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    public static void compileJavaCode(String fileName) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("javac", path + fileName);
        pb.directory(new File(System.getProperty("user.dir")));
        Process process = pb.start();
        int exitCode;
        try {
            exitCode = process.waitFor();
        } catch (InterruptedException e) {
            throw new IOException("Failed to compile Java code.", e);
        }
        if (exitCode != 0) {
            throw new IOException("Failed to compile Java code. Exit code: " + exitCode);
        }
    }

    public static boolean executeJavaCode(String className, String input, String output) throws IOException, InterruptedException, TimeLimitExceededException {
//        String curPath = System.getProperty("user.dir") + "/src/main/java/";
        ProcessBuilder pb = new ProcessBuilder("java", "com.ssafy.codingtestServer." + className);
        pb.directory(new File(System.getProperty("user.dir") + "/src/main/java"));
        Process process = pb.start();

        // 시간 체크 스레드
        Thread timeCheckThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // 시간 제한 만큼 대기
                if (process.isAlive()) {
//                    process.destroy(); // 프로세스 강제 종료
                    System.out.println("자바 프로세스가 시간 제한을 초과하여 종료되었습니다.");
                    isTimeOver.set(true);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        timeCheckThread.start();

        try {
            OutputStream processInputStream = process.getOutputStream();
            processInputStream.write(input.getBytes(StandardCharsets.UTF_8));
            processInputStream.flush();
            processInputStream.close();
            processInputStream.close();

            // 자바 프로세스의 출력 읽기
            BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = processOutputReader.readLine();
            processOutputReader.close();
            if (line.equals(output)) {
                process.waitFor();
                timeCheckThread.interrupt();
                return true;
            } else {
                process.waitFor();
                return false;
            }

        } catch (IOException e) {
            throw new IOException("Failed to execute Java code.", e);
        } catch (TimeLimitExceededException timeLimitExceededException) {
            throw new TimeLimitExceededException();
        }
    }

    public static void exucuteInputFile(OutputStream writer, String fileName) throws IOException {
        try (BufferedReader readFile = new BufferedReader(new FileReader(path + fileName));) {
            writer.write(readFile.readLine().getBytes(StandardCharsets.UTF_8));
            writer.flush();
            writer.close();
        }
    }

    public static class TimeLimitExceededException extends RuntimeException {
        public TimeLimitExceededException() {
            super("시간 제한을 초과하였습니다.");
        }
    }

}
