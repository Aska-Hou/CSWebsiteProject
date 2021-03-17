<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/4
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>About us</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--For images carousel-->
    <script src="https://libs.baidu.com/jquery/1.4.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.carousel.js"></script>
    <!--For Menu-->
    <script type='text/javascript' src='js/superfish3d36.js?ver=3.3.1'></script>
    <script type='text/javascript' src='js/jquery.custom5152.js?ver=1.0'></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type='text/javascript' src='js/jquery-ui-1.8.5.custom.min.js'></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
</head>
<body>

<!-- Header Start-->
<div class="header-wrapper1">
    <div id="header">
        <a href="http://www.wku.edu.cn">
            <img src="images/logo2.jpg" style="height: 77px" id="logoImg1" alt=""/>
            <img src="images/logoImg3.png" style="height: 77px" id="logoImg2" alt=""/></a>
        <img src="images/CSDepartmentLogo.png" id="cslogo" alt=""/>

        <!-- Top Menu Start-->
        <div id="primary-nav">
            <ul id="menu-primary-menu" class="sf-menu">
                <li><a href="index.jsp"><span>Home</span></a></li>

                <li><a href="news_list.jsp"><span>News</span></a></li>

                <li><a href="#" class="sf-with-ul">About Us</a>
                    <ul class="sub-menu">
                        <li><a href="about.jsp"><span>About Us</span></a></li>
                        <li><a href="Document/4-year-plan.pdf" target="_blank"><span>Education Plan</span></a></li>
                    </ul>
                </li>

                <li><a href="#" class="sf-with-ul">Academic</a>
                    <ul class="sub-menu">
                        <li><a href="prof_list.jsp"><span>Faculty Team</span></a></li>
                        <li><a href="publication_list.jsp"><span>Publication</span></a></li>
                        <li><a href="prize_list.jsp"><span>Prize</span></a></li>
                    </ul>
                </li>

                <li><a href="tutor.jsp"><span>Student & Alumni</span></a></li>

            </ul>
            <!-- END #primary-nav -->
        </div>
    </div>
</div>

<div class="aboutTitlePlace">
    <ul class="aboutTitle"><img class="aboutLogo" src="images/logo.png"/> <br/> <br/>Computer Science Department</ul>
</div>

<!-- Middle Part Start-->
<div id="middle-wrapper">
    <!-- Left Section Start-->
    <div class="leftsec">
        <h3>About WKU Computer Science Department</h3>
        <div class="detail">
            <div class="whowe"><img src="images/cs.jpg" style="width: 450px" alt=""/></div>
            <div>
                <p> The Department of Computer Science at Wenzhou-Kean University offers an undergraduate major leading
                    to a
                    B.S. degree. </p>
                <br>

                <p>It was established in 2012 and has produced more than 100 graduates since 2016. Our curriculum
                    follows
                    the one used at Kean University, accredited by ABET. Currently we have six full-time faculty to
                    teach
                    and supervise approximately 180 students. Since the majority of our students will pursue graduate
                    studies following graduation, undergraduate research has become the hallmark of our department.

                </p>
                <br>
                <p> Some
                    of our alumni are pursuing graduate degrees at University of Pennsylvania, Columbia University,
                    Northwestern University, University of Chicago, University of Michigan-Ann Arbor, University of
                    Southern
                    California, University of Maryland-College Park, University of Wisconsin-Madison, UCL (UK),
                    University
                    of Edinburgh (UK), University of Toronto (Canada), University of Melbourne (Australia), etc.</p>
            </div>
        </div>
        <div class="team">

            <h3>Department Scenery</h3>
            <div class="member">
                <div class="team-img"><a href="images/about1.png"> <img src="images/about1.png" class="aboutImg" alt=""/></a></div>
                <strong>WKU Apple Lab </strong> <span>Apple Computer Lab</span>
                <p> WKU Apple Laboratory is in General Education Hall, which provides the excellent devices for CS students to do any kind of experiment </p>
            </div>
            <div class="member">
                <div class="team-img"><a href="images/about2.jpg"> <img src="images/about2.jpg" class="aboutImg" alt=""/></a></div>
                <strong>General Education Hall </strong> <span>GEH CS Classroom</span>
                <p> Currently, WKU Computer Science Department's location is in GEH including the CS lecture classroom and CS Laboratory </p>
            </div>
            <div class="member">
                <div class="team-img"><a href="prof_list.jsp"><img src="images/about3.jpg" class="aboutImg" alt=""/></a></div>
                <strong>CS Professors </strong> <span>Tiffany, Pinatta, Sujatha</span>
                <p> Rich Faculty resources bring the strong Research Energy to WKU Computer Science Department</p>
            </div>
            <div class="member">
                <div class="team-img"><a href="images/about4.png"><img src="images/about4.png" class="aboutImg" alt=""/></a></div>
                <strong>UAV Test</strong> <span>Unmanned Aerial Vehicle</span>
                <p> Many clubs related to the Computer Science Department including the scientific and technical Club is doing experiment</p>
            </div>
        </div>

        <div class="client-box1">
            <div class="client-testimonial1">
                <p> To All WKU CS Student: Don't pay too much attention to your GPA. The aim of going to university is to get the knowledge instead of High GPA.</p>
            </div>
            <div class="client-bg1">Dr Tiffany Tang</div>
        </div>

    </div>
    <!-- Right Section Start-->
    <div class="rightsec">
        <h3>Contact Details</h3>
        <div class="contact">
            <div class="cont-detail"><img src="images/address1.png" alt=""/> <strong>Address:</strong> 88 Daxue Rd,
                Ouhai, Wenzhou, Zhejiang Province, China.
            </div>
            <div class="cont-detail"><img src="images/phone1.png" alt="" width="14" height="18"/>
                <strong>Phone:</strong> +86 (0) 577 5587 0000
            </div>
            <div class="cont-detail"><img src="images/mail1.png" alt="" width="15" height="12"/> <strong>Email:</strong>
                <a href="#">wku@wku.edu.cn</a></div>
        </div>
        <h3 class="map">Google Maps</h3>
        <div class="map"><a href="images/map.png"> <img src="images/map.png" style="width: 100%" alt=""/></a></div>

        <h3>Keep In Touch</h3>
        <ul class="touch">
            <li><a href="#"><img src="images/facebook.png" alt=""/> </a></li>
            <li><a href="#"><img src="images/twitter.png" alt="" border="0"/></a></li>
            <li><a href="#"><img src="images/rss.png" alt="" border="0"/></a></li>
        </ul>
    </div>
</div>
<!-- Footer Part Start-->
<div id="footer">
    <div id="footer-inner">
        <div class="footer-details">
            <div class="logo-btm"><img src="images/logoWhite.jpg" class="footlogo" alt=""/></div>
            <div class="logo-btm"><img src="images/CSDepartmentLogo.png" class="footlogo" alt=""/></div>
            <ul class="social">
                <li class="facebook"><a href="#"> </a></li>
                <li class="twitter"><a href="#"> </a></li>
                <li class="vimeo"><a href="#"> </a></li>
                <li class="linkdin"><a href="#"> </a></li>
                <li class="flickr"><a href="#"> </a></li>
            </ul>
        </div>
        <div class="footer-details">
            <h4>Contact Details</h4>
            <div class="address"><img src="images/address.png" alt=""/>
                <strong>Address:</strong>
                88 Daxue Rd, Ouhai, Wenzhou, Zhejiang Province, China.
            </div>
            <div class="address"><img src="images/phone.png" alt="" width="14" height="18"/> <strong>Phone:</strong> +86
                (0) 577 5587 0000
            </div>
            <div class="address"><img src="images/mail.png" alt="" width="15" height="12"/> <strong>Email:</strong> <a
                    href="mailto:wku@wku.edu.cn">wku@wku.edu.cn</a>, <a href="mailto:cst@wku.edu.cn"> cst@wku.edu.cn</a> </div>
        </div>
        <div class="footer-details">
            <h4>Wechat Accounts</h4>
            <div class="Stream">
                <a href="images/footImg2.png"><img src="images/footImg2.png" style="width: 65px; height: 65px" alt=""/></a>
                <a href="images/footImg1.jpg"><img src="images/footImg1.jpg" style="width: 65px; height: 65px" alt=""/></a>
                <a href="images/footImg3.jpg"><img src="images/footImg3.jpg" style="width: 65px; height: 65px" alt=""/></a>
            </div>
        </div>
        <div class="footer-details no-margin">
            <h4>Learn More about WKU</h4>
            <a href="http://www.wku.edu.cn" style="color: whitesmoke"><p>If you want to learn more about Wenzhou-Kean University, welcome to visit WKU official website</p></a>
        </div>

        <!-- Footer Info Part Start-->
        <div class="Finfo">
            <div class="copyright">&copy; Designed By <a href="tutor.jsp">Aska Hou (Class 2018)</a>, instructed by <a href="prof_detail.jsp?prof_id=18"> Dr.Hemn Barzan Abdalla </a>. Copyright &copy; 2021.WKU CST All rights reserved.
            </div>
        </div>
    </div>
</div>

</body>
</html>
