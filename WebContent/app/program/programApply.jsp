<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로그램 신청 페이지</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/program/programApply.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fix/page.css"/>
    
</head>
<body>
    <jsp:include page="${pageContext.request.contextPath}/app/fix/header.jsp"/>
    <!-- 바디 -->
</div>
    <div class="wrap">
        <div class="main">
            <div class="sub_wrap">
                <div class="sub_title">
                    <div class="container">
                        <div class="inner">
                            <div class="title_left_box">
                                <div id="sub_wrap" class="sub_wrap">
                                    <nav id="snb" class="snb">
                                        <div class="top">
                                            프로그램 신청
                                        </div>
                                        <div class="lgr_snb">
                                            <ul class="lgr_ul">
                                                <li class="nowMenu">
                                                    <a class=a_tag href="${pageContext.request.contextPath}/program/applyListOk.pg"><span class="checkText">농촌 체험 프로그램</span></a>
                                                </li>
                                                <li>
                                                    <a class=a_tag href="${pageContext.request.contextPath}/alba/applyListOk.ab"><span class="secondMenu">농촌 아르바이트</span></a>
                                                </li>
                                            </ul>
                                        </div>
                                    </nav>
                                </div>
                            </div>
                            <div class="title_right_box">
                                <img src="https://www.rda.go.kr/young/file/imageView.do?fpath=78mfPU1tH5tpGdf2EjZQb0R3AXuZGhjU7I8pBv4Rl9tqEaXhOUrKyqO8iZWgudng&fname=8nFVTgUIDUlBiYgKluFrhBdHVni9G2K67o64OtO8tD1DEXBRoHgiiIK%2BvPxFADkbugGa28PnSO6qNVxcSqtCKg%3D%3D&fmime=Lg45aghPCGTl0b%2FVATARWg%3D%3D" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sub_content">
                    <div class="container">
                        <div class="inner">
                            <div class="board_wrap">
                                <div class="board_cont">
                                    <form id="listForm" name="listForm">
                                        <div class="sub01_con inner clearfix">
                                            <div>
                                                <div class="sort_list">
                                                    <button type="button" class="sort_btn" data-id="viewCnt">조회순</button>
                                                    <button type="button" class="sort_btn" data-id="asc">가장최근등록일순</button>
                                                    <button type="button" class="sort_btn" data-id="applEdDt">가장최근마감일순</button>
                                                	<c:if test="${membergrade eq program.getMembergrade()}">
                                                    <button type="button" class="sort_btn_farmer" data-id="register">글 등록</button>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <div class="k_result inner clearfix">
                                                <p class="count">
                                                    총 <span><c:out value="${totalCount}"/></span>건 (진행중 
                                                	<span>247</span>건) 
                                                </p>
                                                <br>
                                                <ul style="margin: 0px">
                                                		<c:if test="${programs != null and fn:length(programs) > 0}">
                                                			<c:forEach var="program" items="${programs}">
                                                    <li>
                                                        
                                                            <div class="info">
                                                                <p class="local"><c:out value="${program.getProgramLocation()}"/></p>
                                                                <!-- 진행사항 -->
                                                                <p class="progress">진행중</p>
                                                                <!-- 지원금액 -->
                                                            </div>
                                                            <div class="title">
                                                                <p><c:out value="${program.getProgramName()}"/></p>
                                                            </div>
                                                            <div class="num">
                                                                <p class="prd">
                                                                    <span class="endstatus">D-1</span> &nbsp; | &nbsp; <c:out value="${program.getProgramApplyEndDate()}"/></p>
                                                                <p class="hits"><img src="https://www.rda.go.kr/young/images/site/sub/common_ico_view.png"> <c:out value="${program.getProgramViewCount()}"/></p>
                                                            </div>
                                                            <div class="file">
                                                            </div>
                                                        
                                                    </li>
                                                			</c:forEach>
                                                		</c:if>
                                                </ul>
                                            </div>
                                           
                                        </div>
                                       <!-- 페이징 -->
                                        <div id="page" style="margin-bottom : 30px">
                                            <div class="page_nation">
                                            	<c:if test="${prev}">
			                                            <a class="page-num arrow pprev" href="${pageContext.request.contextPath}/program/applyListOk.pg?page=1"></a>
			                                            <a class="page-num arrow prev" href="${pageContext.request.contextPath}/program/applyListOk.pg?page=${startPage - 1}"></a>
			                                    </c:if>
	                                            <c:forEach var="i" begin="${startPage}" end="${endPage}">
	                                            <c:choose>
															<c:when test="${not (i eq page)}">
			                                            		<a class="page-num " href="${pageContext.request.contextPath}/program/applyListOk.pg?page=${i}">
			                                            		<c:out value="${i}"/></a>
															</c:when>
															<c:otherwise>
			                                            		<a class="page-num active" href="${pageContext.request.contextPath}/program/applyListOk.pg?page=${i}">
			                                            		<c:out value="${i}"/></a>
															</c:otherwise>
														</c:choose>
	                                            </c:forEach>
	                                            <c:if test="${next}">
			                                            <a class="page-num arrow next" href="${pageContext.request.contextPath}/program/applyListOk.pg?page=${endPage + 1}"></a>
			                                            <a class="page-num arrow nnext" href="${pageContext.request.contextPath}/program/applyListOk.pg?page=${realEndPage}"></a>
			                                    </c:if>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="${pageContext.request.contextPath}/app/fix/footer.jsp"/>
</body>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

</html>