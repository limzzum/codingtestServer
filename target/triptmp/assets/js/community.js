console.log("Load community.js");


function selectGongFromLocal(){
    let localData = `
    <tbody>
          <tr>
            <td>1</td>
            <td>Larry the Bird</td>
            <td>ssafy</td>
            <td>2023.01.01</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Larry the Bird</td>
            <td>ssafy</td>
            <td>2023.01.01</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Larry the Bird</td>
            <td>ssafy</td>
            <td>2023.01.01</td>
          </tr>
        </tbody>
    `;
    return localData;
}

function selectTipFromLocal(){
    let localData = `
    <tbody>
          <tr>
            <td>1</td>
            <td>Tip1</td>
            <td>User1</td>
            <td>2023.01.01</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Tip2</td>
            <td>User2</td>
          </tr>
          <tr>
            <td>3</td>
            <td>Tip3</td>
            <td>User3</td>
          </tr>
        </tbody>
    `;
    return localData;
}

function selectHotplaceFromLocal(){
    let localData = ``;
    for(let i=0; i<10; i++){
        localData += `
<div class="card m-2" style="width: 18rem;">
  <img src="assets/img/testimg.png" class="card-img-top m-0">
  <div class="card-body">
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>`;
    }
    return localData;
}

let communityContent = document.querySelectorAll("#content-community> div");
function closeAllCommunityContent(){
    for(let i=1; i<communityContent.length; i++){
        communityContent[i].setAttribute("class","d-none");
    }
}
let communityList = document.querySelectorAll("#community-list>input");

document.getElementById("nav-community").addEventListener("click",()=>{
    closeAllContent();
    openContentById("content-community","container");
    closeAllCommunityContent();
    communityList[0].click();
});

communityList[0].addEventListener("click",()=>{
    closeAllCommunityContent();
    document.getElementById("community-gong").setAttribute("class","row m-2");

    let table = document.querySelector("#community-gong> div> table");
    table.innerHTML= `            
         <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">Subject</th>
                <th scope="col">ID</th>
                <th scope="col">Date</th>
             </tr>
          </thead>`;
    table.innerHTML+=selectGongFromLocal();
});

communityList[1].addEventListener("click",()=>{
    closeAllCommunityContent();
    document.getElementById("community-tip").setAttribute("class","row m-2");

    let table = document.querySelector("#community-tip> div> table");
    table.innerHTML= `            
         <thead>
            <tr>
                <th scope="col">No</th>
                <th scope="col">Subject</th>
                <th scope="col">ID</th>
                <th scope="col">Date</th>
            </tr>
          </thead>`;
    table.innerHTML+=selectTipFromLocal();
});

communityList[2].addEventListener("click",()=>{
    closeAllCommunityContent();
    document.getElementById("community-hotplace").setAttribute("class","row m-2");

    let hotplaceList = document.querySelector("#hotplace");
    hotplaceList.innerHTML+=selectHotplaceFromLocal();
});

communityList[2].addEventListener("click",()=>{
    closeAllCommunityContent();
    document.getElementById("community-hotplace").setAttribute("class","row m-2");

    let hotplaceList = document.querySelector("#hotplace");
    hotplaceList.innerHTML+=selectHotplaceFromLocal();
});


document.getElementById("community-tip-write-start").addEventListener("click",()=>{
    closeAllCommunityContent();
    openContentById("community-tip-write","row m-2");
});

document.getElementById("community-tip-write-end").addEventListener("click",()=>{
    closeAllCommunityContent();
    openContentById("community-tip","row m-2");
});

document.getElementById("community-gong-write-start").addEventListener("click",()=>{
    closeAllCommunityContent();
    openContentById("community-gong-write","row m-2");
});

document.getElementById("community-gong-write-end").addEventListener("click",()=>{
    closeAllCommunityContent();
    openContentById("community-gong","row m-2");
});