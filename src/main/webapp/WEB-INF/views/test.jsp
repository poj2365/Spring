<%--
  Created by IntelliJ IDEA.
  User: poj23
  Date: 25. 6. 12.
  Time: 오후 4:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EduCenter - 오프라인 강의 예약</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
            line-height: 1.6;
            color: #333;
            background-color: #f8f9fa;
        }

        /* Header */
        .header {
            background: white;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            position: sticky;
            top: 0;
            z-index: 100;
        }

        .nav-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 70px;
        }

        .logo {
            font-size: 28px;
            font-weight: bold;
            color: #00c471;
            text-decoration: none;
        }

        .nav-menu {
            display: flex;
            list-style: none;
            gap: 30px;
        }

        .nav-menu a {
            text-decoration: none;
            color: #333;
            font-weight: 500;
            transition: color 0.3s;
        }

        .nav-menu a:hover {
            color: #00c471;
        }

        .auth-buttons {
            display: flex;
            gap: 10px;
        }

        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.3s;
            text-decoration: none;
            display: inline-block;
        }

        .btn-outline {
            background: transparent;
            color: #00c471;
            border: 1px solid #00c471;
        }

        .btn-outline:hover {
            background: #00c471;
            color: white;
        }

        .btn-primary {
            background: #00c471;
            color: white;
        }

        .btn-primary:hover {
            background: #00a85f;
        }

        /* Hero Section */
        .hero {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 80px 0;
            text-align: center;
        }

        .hero-content {
            max-width: 800px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .hero h1 {
            font-size: 48px;
            margin-bottom: 20px;
            font-weight: 700;
        }

        .hero p {
            font-size: 20px;
            margin-bottom: 30px;
            opacity: 0.9;
        }

        /* Search Section */
        .search-section {
            background: white;
            padding: 40px 0;
        }

        .search-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .search-form {
            display: flex;
            gap: 15px;
            max-width: 800px;
            margin: 0 auto;
        }

        .search-input {
            flex: 1;
            padding: 15px 20px;
            border: 2px solid #e9ecef;
            border-radius: 8px;
            font-size: 16px;
        }

        .search-input:focus {
            outline: none;
            border-color: #00c471;
        }

        .search-btn {
            padding: 15px 30px;
            background: #00c471;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
        }

        /* Filters */
        .filters {
            display: flex;
            gap: 15px;
            margin-top: 20px;
            flex-wrap: wrap;
        }

        .filter-select {
            padding: 10px 15px;
            border: 1px solid #dee2e6;
            border-radius: 6px;
            background: white;
            cursor: pointer;
        }

        /* Course Grid */
        .courses-section {
            padding: 60px 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
        }

        .section-title {
            font-size: 32px;
            margin-bottom: 40px;
            text-align: center;
            color: #333;
        }

        .course-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
            gap: 30px;
        }

        .course-card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0,0,0,0.1);
            transition: transform 0.3s, box-shadow 0.3s;
            cursor: pointer;
        }

        .course-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 30px rgba(0,0,0,0.15);
        }

        .course-image {
            width: 100%;
            height: 200px;
            background: linear-gradient(45deg, #667eea, #764ba2);
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            font-size: 24px;
            font-weight: bold;
        }

        .course-content {
            padding: 25px;
        }

        .course-category {
            color: #00c471;
            font-size: 14px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .course-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 15px;
            color: #333;
            line-height: 1.4;
        }

        .course-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 15px;
            font-size: 14px;
            color: #666;
        }

        .course-schedule {
            background: #f8f9fa;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .schedule-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 8px;
        }

        .schedule-item:last-child {
            margin-bottom: 0;
        }

        .course-price {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .price {
            font-size: 24px;
            font-weight: bold;
            color: #00c471;
        }

        .btn-book {
            background: #00c471;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 6px;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.3s;
        }

        .btn-book:hover {
            background: #00a85f;
        }

        /* Footer */
        .footer {
            background: #343a40;
            color: white;
            padding: 50px 0 30px;
            margin-top: 80px;
        }

        .footer-content {
            max-width: 1200px;
            margin: 0 auto;
            padding: 0 20px;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 40px;
        }

        .footer-section h3 {
            margin-bottom: 20px;
            color: #00c471;
        }

        .footer-section p, .footer-section a {
            color: #adb5bd;
            text-decoration: none;
            line-height: 1.8;
        }

        .footer-section a:hover {
            color: white;
        }

        /* Responsive */
        @media (max-width: 768px) {
            .nav-menu {
                display: none;
            }

            .hero h1 {
                font-size: 36px;
            }

            .search-form {
                flex-direction: column;
            }

            .filters {
                justify-content: center;
            }

            .course-grid {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
<!-- Header -->
<header class="header">
    <div class="nav-container">
        <a href="#" class="logo">EduCenter</a>
        <nav>
            <ul class="nav-menu">
                <li><a href="#courses">강의 목록</a></li>
                <li><a href="#schedule">시간표</a></li>
                <li><a href="#instructors">강사진</a></li>
                <li><a href="#contact">문의</a></li>
            </ul>
        </nav>
        <div class="auth-buttons">
            <a href="#login" class="btn btn-outline">로그인</a>
            <a href="#signup" class="btn btn-primary">회원가입</a>
        </div>
    </div>
</header>

<!-- Hero Section -->
<section class="hero">
    <div class="hero-content">
        <h1>전문가와 함께하는<br>오프라인 강의</h1>
        <p>실무 경험이 풍부한 강사진과 함께 직접 배우고 성장하세요</p>
    </div>
</section>

<!-- Search Section -->
<section class="search-section">
    <div class="search-container">
        <form class="search-form" action="searchCourses.jsp" method="GET">
            <input type="text" name="keyword" class="search-input" placeholder="관심있는 강의를 검색해보세요">
            <button type="submit" class="search-btn">검색</button>
        </form>
        <div class="filters">
            <select class="filter-select" name="category">
                <option value="">카테고리</option>
                <option value="programming">프로그래밍</option>
                <option value="design">디자인</option>
                <option value="business">비즈니스</option>
                <option value="language">외국어</option>
            </select>
            <select class="filter-select" name="level">
                <option value="">난이도</option>
                <option value="beginner">초급</option>
                <option value="intermediate">중급</option>
                <option value="advanced">고급</option>
            </select>
            <select class="filter-select" name="location">
                <option value="">지역</option>
                <option value="seoul">서울</option>
                <option value="busan">부산</option>
                <option value="daegu">대구</option>
            </select>
        </div>
    </div>
</section>

<!-- Courses Section -->
<section class="courses-section" id="courses">
    <div class="container">
        <h2 class="section-title">인기 강의</h2>
        <div class="course-grid">
            <!-- Course Card 1 -->
            <div class="course-card" onclick="location.href='courseDetail.jsp?id=1'">
                <div class="course-image">
                    Java Spring
                </div>
                <div class="course-content">
                    <div class="course-category">프로그래밍</div>
                    <h3 class="course-title">실무자를 위한 Java Spring Boot 마스터</h3>
                    <div class="course-info">
                        <span>📍 강남구</span>
                        <span>⭐ 4.8 (127)</span>
                    </div>
                    <div class="course-schedule">
                        <div class="schedule-item">
                            <span>수업 기간:</span>
                            <span>4주 (16시간)</span>
                        </div>
                        <div class="schedule-item">
                            <span>수업 시간:</span>
                            <span>매주 토 14:00-18:00</span>
                        </div>
                        <div class="schedule-item">
                            <span>시작일:</span>
                            <span>2025.07.05</span>
                        </div>
                    </div>
                    <div class="course-price">
                        <span class="price">₩280,000</span>
                        <button class="btn-book">예약하기</button>
                    </div>
                </div>
            </div>

            <!-- Course Card 2 -->
            <div class="course-card" onclick="location.href='courseDetail.jsp?id=2'">
                <div class="course-image">
                    UI/UX Design
                </div>
                <div class="course-content">
                    <div class="course-category">디자인</div>
                    <h3 class="course-title">실무 UI/UX 디자인 완성 과정</h3>
                    <div class="course-info">
                        <span>📍 홍대</span>
                        <span>⭐ 4.9 (89)</span>
                    </div>
                    <div class="course-schedule">
                        <div class="schedule-item">
                            <span>수업 기간:</span>
                            <span>6주 (24시간)</span>
                        </div>
                        <div class="schedule-item">
                            <span>수업 시간:</span>
                            <span>매주 화목 19:00-21:00</span>
                        </div>
                        <div class="schedule-item">
                            <span>시작일:</span>
                            <span>2025.07.08</span>
                        </div>
                    </div>
                    <div class="course-price">
                        <span class="price">₩350,000</span>
                        <button class="btn-book">예약하기</button>
                    </div>
                </div>
            </div>

            <!-- Course Card 3 -->
            <div class="course-card" onclick="location.href='courseDetail.jsp?id=3'">
                <div class="course-image">
                    Digital Marketing
                </div>
                <div class="course-content">
                    <div class="course-category">비즈니스</div>
                    <h3 class="course-title">디지털 마케팅 전략과 실전 노하우</h3>
                    <div class="course-info">
                        <span>📍 강남구</span>
                        <span>⭐ 4.7 (156)</span>
                    </div>
                    <div class="course-schedule">
                        <div class="schedule-item">
                            <span>수업 기간:</span>
                            <span>8주 (32시간)</span>
                        </div>
                        <div class="schedule-item">
                            <span>수업 시간:</span>
                            <span>매주 수 19:00-23:00</span>
                        </div>
                        <div class="schedule-item">
                            <span>시작일:</span>
                            <span>2025.07.10</span>
                        </div>
                    </div>
                    <div class="course-price">
                        <span class="price">₩420,000</span>
                        <button class="btn-book">예약하기</button>
                    </div>
                </div>
            </div>

            <!-- Course Card 4 -->
            <div class="course-card" onclick="location.href='courseDetail.jsp?id=4'">
                <div class="course-image">
                    React Native
                </div>
                <div class="course-content">
                    <div class="course-category">프로그래밍</div>
                    <h3 class="course-title">React Native로 만드는 모바일 앱</h3>
                    <div class="course-info">
                        <span>📍 판교</span>
                        <span>⭐ 4.6 (94)</span>
                    </div>
                    <div class="course-schedule">
                        <div class="schedule-item">
                            <span>수업 기간:</span>
                            <span>5주 (20시간)</span>
                        </div>
                        <div class="schedule-item">
                            <span>수업 시간:</span>
                            <span>매주 일 10:00-14:00</span>
                        </div>
                        <div class="schedule-item">
                            <span>시작일:</span>
                            <span>2025.07.13</span>
                        </div>
                    </div>
                    <div class="course-price">
                        <span class="price">₩320,000</span>
                        <button class="btn-book">예약하기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer class="footer">
    <div class="footer-content">
        <div class="footer-section">
            <h3>EduCenter</h3>
            <p>전문가와 함께하는 오프라인 교육의 새로운 경험을 제공합니다.</p>
            <p>📧 info@educenter.com</p>
            <p>📞 02-1234-5678</p>
        </div>
        <div class="footer-section">
            <h3>강의 카테고리</h3>
            <p><a href="#">프로그래밍</a></p>
            <p><a href="#">디자인</a></p>
            <p><a href="#">비즈니스</a></p>
            <p><a href="#">외국어</a></p>
        </div>
        <div class="footer-section">
            <h3>고객 지원</h3>
            <p><a href="#">자주 묻는 질문</a></p>
            <p><a href="#">환불 정책</a></p>
            <p><a href="#">이용 약관</a></p>
            <p><a href="#">개인정보 처리방침</a></p>
        </div>
        <div class="footer-section">
            <h3>소셜 미디어</h3>
            <p><a href="#">Facebook</a></p>
            <p><a href="#">Instagram</a></p>
            <p><a href="#">YouTube</a></p>
            <p><a href="#">Blog</a></p>
        </div>
    </div>
</footer>

<script>
    // 검색 기능
    document.querySelector('.search-form').addEventListener('submit', function(e) {
        e.preventDefault();
        const keyword = document.querySelector('input[name="keyword"]').value;
        if (keyword.trim()) {
            alert('검색어: ' + keyword + '\n(실제로는 searchCourses.jsp로 이동합니다)');
        }
    });

    // 예약 버튼 클릭 이벤트
    document.querySelectorAll('.btn-book').forEach(button => {
        button.addEventListener('click', function(e) {
            e.stopPropagation();
            alert('예약 페이지로 이동합니다.\n(실제로는 booking.jsp로 이동)');
        });
    });

    // 카드 호버 효과
    document.querySelectorAll('.course-card').forEach(card => {
        card.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-8px)';
        });

        card.addEventListener('mouseleave', function() {
           this.style.transform = 'translateY(0)';
        });
    });
</script>
</body>
</html>