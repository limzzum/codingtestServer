console.log("Load main.js");

document.getElementById("content-mypage-mvupdate").addEventListener("click",()=>{
    openContentById("content-mypage-mvupdate","d-none btn btn-outline-secondary float-end");
    openContentById("content-mypage-update","btn btn-outline-secondary float-end");
    document.getElementById("content-mypage-password").disabled =false;
    document.getElementById("content-mypage-name").disabled =false;
    document.getElementById("content-mypage-address").disabled =false;
});

document.getElementById("content-mypage-update").addEventListener("click",()=>{
    openContentById("content-mypage-mvupdate","btn btn-outline-secondary float-end");
    openContentById("content-mypage-update","d-none btn btn-outline-secondary float-end");
    document.getElementById("content-mypage-password").disabled =true;
    document.getElementById("content-mypage-name").disabled =true;
    document.getElementById("content-mypage-address").disabled =true;
});

let myTipTableHead = `           
            <thead>
            <tr>
              <th scope="col">No</th>
              <th scope="col">Subject</th>
              <th scope="col">Id</th>
              <th scope="col">Date</th>
            </tr>
            </thead>
`;