<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
        <meta charset="utf-8">
        <title>날씨 정보</title>
        
        <!-- bootstrap CDN link -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="/lesson05/test05/css/style.css" type="text/css">
</head>
<body>
    <div id="wrap">
            <div class="d-flex">
                <nav>
                    <div class="logo d-flex justify-content-center mt-3">
                        <img class="logo-image mr-2" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/Emblem_of_the_Government_of_the_Republic_of_Korea.svg/800px-Emblem_of_the_Government_of_the_Republic_of_Korea.svg.png" > 
                        <span class="text-white logo-text">기상청</span>
                    </div>

                    <ul class="nav flex-column mt-4">
                        <li class="nav-item"><a href="/lesson05/weather_history" class="nav-link main-link">날씨</a></li>
                        <li class="nav-item"><a href="/lesson05/weather_input" class="nav-link main-link">날씨입력</a></li>
                        <li class="nav-item"><a href="#" class="nav-link main-link">테마날씨</a></li>
                        <li class="nav-item"><a href="#" class="nav-link main-link">관측 기후</a></li>
                    </ul>
                </nav>
                <section class="mt-3 ml-5">
                    <h3>과거 날씨</h3>
                    <table class="table text-center">
                        <thead>
                            <tr>
                                <th>날짜</th>
                                <th>날씨</th>
                                <th>기온</th>
                                <th>강수량</th>
                                <th>미세먼지</th>
                                <th>풍속</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="weather" items="${weatherHistory }" >
                        	<tr>
                        		<td><fmt:formatDate value="${weather.date }" pattern="yyyy년 M월 d일" /> </td>
                        		<!-- 
                        		<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
                        		 -->
                        		<c:choose>
                        			<c:when test="${weather.weather eq '맑음' }">
                        				<td><img src="http://marondal.com/material/images/dulumary/web/jstl/sunny.jpg"></td>
                        			</c:when>
                        			<c:when test="${weather.weather eq '구름조금' }" >
                        				<td><img src="http://marondal.com/material/images/dulumary/web/jstl/partlyCloudy.jpg"></td>
                        			</c:when>
                        			<c:when test="${weather.weather eq '흐림' }" >
                        				<td><img src="http://marondal.com/material/images/dulumary/web/jstl/cloudy.jpg"></td>
                        			</c:when>
                        			<c:when test="${weather.weather eq '비' }" >
                        				<td><img src="http://marondal.com/material/images/dulumary/web/jstl/rainy.jpg"></td>
                        			</c:when>
                        			<c:otherwise>
                        				<td>${weather.weather }</td>
                        			</c:otherwise>
                        		</c:choose>
           
                        		<td>${weather.temperatures }℃</td>
                        		<td>${weather.precipitation }mm</td>
                        		<td>${weather.microDust }</td>
                        		<td>${weather.windSpeed }km/h</td>      		
                        	</tr>
   							</c:forEach>
                        	
                        </tbody>

                    </table>
                    
                </section>
            </div>
            <footer class="border-top d-flex">
                <div class="footer-logo mt-3 ml-4"> <img class="foot-logo-image" src="https://www.weather.go.kr/w/resources/image/foot_logo.png"></div>
                <div class="copyright mt-2">
                    <small class="text-secondary">(07062) 서울시 동작구 여의대방로16길 61  <br>
                    Copyright@2020 KMA. All Rights RESERVED.</small>

                </div>
            </footer>
        </div>
        
    </body>

</html>

</body>
</html>