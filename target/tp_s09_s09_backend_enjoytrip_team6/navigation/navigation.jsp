<%--
  Created by IntelliJ IDEA.
  User: wangjunyoung
  Date: 2023/03/26
  Time: 12:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container px-4 px-lg-5">
    <a class="navbar-brand" href="#!" id="nav-home">박한샘</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
            class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">

        <!--nav : search-->
        <li class="nav-item">
          <a class="nav-link" href="#!" id="nav-search">
            Search
          </a>
        </li>

        <!--nav : community-->
        <li class="nav-item" id="nav-community">
          <a class="nav-link" href="#!">
            <i class="bi bi-chat-right-text"></i>
            Community
          </a>
        </li>

        <!--nav : plan-->
        <div class="nav-item dropdown" style="display:block">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="bi bi-calendar-plus"></i>
            Plan
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
              <a class="dropdown-item" href="#!" id="nav-addplan">
                Add Plan
              </a>
            </li>
            <li>
              <a class="dropdown-item" href="#!" id="nav-timeline">
                TimeLines
              </a>
            </li>
          </ul>
        </div>
      </ul>

      <!--nav : before-login-->
      <c:if test="${empty userInfo}">
        <div class="nav-item dropdown" id="joinNav">
          <a class="nav-link dropdown-toggle" id="logoutDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="bi bi-calendar-plus"></i>
            Add Trip
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
              <a class="dropdown-item" href="#!" id="nav-login" onclick="navLogin()">LogIn</a>
            </li>
            <li>
              <hr class="dropdown-divider" />
            </li>
            <li><a class="dropdown-item" href="#!" id="nav-join" onclick="navJoin()">Join</a></li>
            <li><a class="dropdown-item" href="#!" id="nav-problem">Problem</a></li>
          </ul>
        </div>

      </c:if>

      <!--nav : after-login-->
      <c:if test="${!empty userInfo}">
        <div class="nav-item dropdown" id="myNav">
          <a class="nav-link dropdown-toggle" id="loginDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <i class="bi bi-person-circle"></i>
            ${userInfo.name}님
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="#!" id="nav-mypage" onclick="navMypage()">Information</a></li>
            <li>
              <hr class="dropdown-divider" />
            </li>
            <li><a class="dropdown-item" href="#!" id="nav-myplan" onclick="navMyplan()">My Plan</a></li>
            <li><a class="dropdown-item" href="#!" id="nav-mytip" onclick="navMytip()">My Tip</a></li>
            <li><a class="dropdown-item" href="#!" id="nav-myhotplace" onclick="navMyhotplace()">My Hotplace</a></li>
            <li>
              <hr class="dropdown-divider" />
            </li>
            <li><a class="dropdown-item" href="#!" id="nav-logout" onclick="navLogout()">LogOut</a></li>
          </ul>
        </div>
      </c:if>



    </div>
  </div>
</nav>

