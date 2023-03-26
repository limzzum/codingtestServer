console.log("Load main.js");

var SERVER_URL = "http://localhost:8080/trip/trip/";

async function fillArea(){
    let serviceKey = "GPwmEPv1%2FDJFLMiKSip8uedsDWq58hPd%2FIO4sSzE%2BYRxZK28Mp7E9bG3QT2h3t%2BfSzFgSumVHrwnEca%2FNc7T3w%3D%3D";
    let areaUrl = "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
        serviceKey +
        "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

    let response = await fetch(areaUrl);
    let json = await response.json();
    let result = json.response.body.items.item;
    let sa= document.querySelector("#search-area");

    sa.innerHTML = document.querySelector("#search-area> option:first-child").outerHTML;

    result.forEach((item) => {
        sa.innerHTML += `<option value="${item.code}"> ${item.name}</option>`;
    });
}
fillArea();


let content = document.querySelectorAll(".content> div");

function closeAllContent(){
    content.forEach((element)=>{
        element.setAttribute("class","d-none");
    });
}

function openContentById(id,display = "container"){
    document.getElementById(id).setAttribute("class",display);
}

document.getElementById("nav-home").addEventListener("click",()=>{
    closeAllContent();
    openContentById("content-home");
});

document.getElementById("nav-search").addEventListener("click",()=>{
    closeAllContent();
    openContentById("content-search")
});

document.getElementById("nav-addplan").addEventListener("click",()=>{
    closeAllContent();
    openContentById("content-plan-add");
});




/**
 * User Service - Login & LogOut
 */


function navLogin(){
    closeAllContent();
    openContentById("content-login");
}

async function contentLogin(){
    let id = document.getElementById("content-login-id").value;
    let password = document.getElementById("content-login-password").value;
    let requestUrl = SERVER_URL + "user";

    let body = {
        "action" : "login",
        "user": {
            id: id,
            password:password,
        }
    };

    let requestData = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(body),
    };

    let response = await fetch(requestUrl,requestData);
    let json = await response.json();

    if(json.id == "FAIL") {
        alert("비밀번호 오류");}
    else{
        location.reload();
    }
}

async function navLogout(){
    closeAllContent();
    openContentById("content-home");

    let requestUrl = SERVER_URL + "user";
    let body = {
        "action" : "logout",
    };

    let requestData = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(body),
    };

    fetch(requestUrl,requestData)
        .then(()=>{location.reload();});
}


/**
 * User Service - Join
 */

function navJoin(){
    closeAllContent();
    openContentById("content-join");
}

async function contentJoin(){

}




function navMypage(){
    closeAllContent();
    openContentById("content-mypage");
}


function navMyplan(){
    closeAllContent();
    openContentById("content-myplan");
}


function navMytip(){
    closeAllContent();
    openContentById("content-mytip");
}


function navMyhotplace(){
    closeAllContent();
    openContentById("content-myhotplace");
}

