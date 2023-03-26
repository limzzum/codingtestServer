<%--
  Created by IntelliJ IDEA.
  User: wangjunyoung
  Date: 2023/03/26
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <%@ include file="/main/head.jsp"%>
</head>

<body>
<!-- Navigation-->
<%@ include file="/navigation/navigation.jsp"%>
<!--Content-->
<div class = "content">
    <!--home-->

    <div class = "container" id="content-home">

        home

    </div>

    <!--content : search-->
    <div class = "d-none" id="content-search">
        <div class="row mt-5">
            <div class="col-2"></div>
            <div class="col-8">
                <div class="input-group" role="search">
                    <select id="search-area" class="form-select" aria-label="Default select example">
                        <option value="0" selected>검색 할 지역 선택</option>
                    </select>
                    <input id="search-keyword" class="form-control" type="search" placeholder="검색어" aria-label="검색어"/>

                    <select id="search-content-id" class="form-select">
                        <option value="0" selected>관광지 유형</option>
                        <option value="12">관광지</option>
                        <option value="14">문화시설</option>
                        <option value="15">축제공연행사</option>
                        <option value="25">여행코스</option>
                        <option value="28">레포츠</option>
                        <option value="32">숙박</option>
                        <option value="38">쇼핑</option>
                        <option value="39">음식점</option>
                    </select>

                    <button id="btn-search" class="btn btn-outline-secondary" type="button"><i class="bi bi-search"></i></button>
                </div>
            </div>
        </div>

        <div class="row mt-2">
            <div class="col-2">
            </div>
            <div class="col-8">
                <div id="map" style="width:100%;height:600px;"></div>
                <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0b84fd1237aed5cea2801ea80e6e9738&libraries=services,clusterer,drawing"></script>

                <table class="table table-striped" id="search-table">
                </table>
            </div>
        </div>
    </div>

    <!--content : plan-->
    <div class = "d-none" id="content-plan-add">


        <div class = "row m-2" id="plan-add-one">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Subject" aria-label="Subject" aria-describedby="basic-addon1">
                <button class="btn btn-outline-secondary" type="button" id="button-addon2">Input</button>
            </div>
        </div>

        <div class = "row m-2">
            <div class="d-grid gap-2">
                <button type="button" class="btn btn-outline-secondary">Add Day</button>
            </div>
        </div>


        <div class="card m-2 p-5" id="plan-add-three">
            <form>
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="plan-add-day-subject">
                    <label for="plan-add-day-subject">Subject</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="time" class="form-control" id="plan-add-day-time">
                    <label for="plan-add-day-time">Time</label>
                </div>

                <div class="form-floating mb-3">
                    <input type="textarea" class="form-control" id="plan-add-day-content">
                    <label for="plan-add-day-content">Content</label>
                </div>

                <button type="submit" class="btn btn-primary">Add</button>
            </form>
        </div>

    </div>

    <div class = "d-none" id="content-plan-share">
        id : content-plan-share
    </div>

    <!--content : community-->
    <div class = "d-none" id="content-community">
        <div class="row m-2">
            <div class="btn-group" role="group" id="community-list">
                <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off" value="community-gong" checked>
                <label class="btn btn-light btn-outline-dark" for="btnradio1">공지사항</label>

                <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off" value="community-tip">
                <label class="btn btn-light btn-outline-dark" for="btnradio2">Tip</label>

                <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off" value="community-hotplace">
                <label class="btn btn-light btn-outline-dark" for="btnradio3">Hot Place</label>
            </div>
        </div>

        <div class="d-none" id="community-gong">
            <div class="col">
                <button type="button" class="btn btn-outline-dark float-end" id="community-gong-write-start"><i class="bi bi-pencil"></i>
                </button>
                <table class="table">

                </table>
            </div>
        </div>

        <div class="d-none" id="community-gong-write">
            <div class="col">
                <button type="button" class="btn btn-outline-dark float-end" id="community-gong-write-end"><i class="bi bi-pencil-square"></i></i>
                </button>
                <form>
                    <div class="mt-5 mb-2">
                        <label for="community-gong-write-subject" class="form-label" >Subject</label>
                        <input type="text" class="form-control" id="community-gong-write-subject">
                    </div>
                    <div class="mt-3 mb-2">
                        <label for="community-gong-write-content" class="form-label">Content</label>
                        <textarea class="form-control" id="community-gong-write-content" rows="15"></textarea>
                    </div>
                </form>
            </div>
        </div>

        <div class="d-none" id="community-tip">
            <div class="col">
                <button type="button" class="btn btn-outline-dark float-end" id="community-tip-write-start"><i class="bi bi-pencil"></i>
                </button>
                <table class="table">
                </table>
            </div>
        </div>

        <div class="d-none" id="community-tip-write">
            <div class="col">
                <button type="button" class="btn btn-outline-dark float-end" id="community-tip-write-end"><i class="bi bi-pencil-square"></i></i>
                </button>
                <form>
                    <div class="mt-5 mb-2">
                        <label for="community-tip-write-subject" class="form-label" >Subject</label>
                        <input type="text" class="form-control" id="community-tip-write-subject">
                    </div>
                    <div class="mt-3 mb-2">
                        <label for="community-tip-write-content" class="form-label">Content</label>
                        <textarea class="form-control" id="community-tip-write-content" rows="15"></textarea>
                    </div>
                </form>
            </div>
        </div>

        <div class="d-none" id="community-hotplace">
            <div class="col">
                <button type="button" class="btn btn-outline-dark float-end" id="hotplace-write">
                    <i class="bi bi-pencil"></i>
                </button>
            </div>
            <div class="row" id="hotplace">
            </div>
        </div>
    </div>


    <!--content : login-->
    <%@include file="user/login.jsp"%>

    <!--content : join-->
    <%@include file="user/join.jsp"%>

    <!--content : mypage-->
    <div class = "d-none" id="content-mypage">
        <div class="row mt-5 mb-5">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card">
                    <div class="card-body">
                        <form id = "content-mypage-form">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="content-mypage-id" placeholder="ID" disabled>
                                <label for="content-mypage-id">ID</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="password" class="form-control" id="content-mypage-password" disabled>
                                <label for="content-mypage-password">Password</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="content-mypage-name" placeholder="Name" disabled>
                                <label for="content-mypage-name">Name</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control" id="content-mypage-address" placeholder="Address" disabled>
                                <label for="content-mypage-address">Address</label>
                            </div>
                            <button type="submit" class="btn btn-outline-secondary float-end" id="content-mypage-mvupdate">수정하기</button>
                            <button type="submit" class="d-none btn btn-outline-secondary float-end" id="content-mypage-update">변경 사항 적용</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-4"></div>
        </div>

    </div>



    <div class = "d-none" id="content-myplan">
        myplan
    </div>

    <div class = "d-none" id="content-mytip">
        <div class="row m-5">
            <div class="col3"></div>
            <div class="col6">
                <table class="table" id="content-mypage-mytip-table">
                </table>
            </div>
        </div>
    </div>

    <div class = "d-none" id="content-myhotplace">
        <div class="row" id="content-mypage-hotplace">

        </div>
    </div>



</div>

<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/main.js"></script>
<script src="assets/js/search.js"></script>
<script src="assets/js/community.js"></script>
<script src="assets/js/mypage.js"></script>
</html>