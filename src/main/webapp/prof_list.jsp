<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/4
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Professor Team</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--For images carousel-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <%--    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>--%>
    <!--For Portfolio-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="js/setting.js"></script>
    <!--For Menu-->
    <script type='text/javascript' src='js/superfish3d36.js?ver=3.3.1'></script>
    <script type='text/javascript' src='js/jquery.custom5152.js?ver=1.0'></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <!--    <script type='text/javascript' src='js/jquery-ui-1.8.5.custom.min.js'></script>-->
    <script src="https://cdn.bootcdn.net/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script>
        $(function () {
            var list = $("#prof_list");
            list.empty();
            $.post("professor/showProfessorList", null, function (data) {
                $.each(data, function (index, object) {
                    list.append("<ul class=\"profBlock\">\n" +
                        "                <li>\n" +
                        "                    <div class=\"profImg\"><img src=\"/CSWebsite/" + object.photo + "\" class=\"photo1\" alt=\"\"></div>\n" +
                        "                    <div class=\"text1\">\n" +
                        "                        <p class=\"profName\">" + object.name + "</p>\n" +
                        "                        <br/>\n" +
                        "                        <p class=\"profDescription\">" + object.introduction.replace(/\n/g, "<br/>") + "</p>\n" +
                        "                        <br/>\n" +
                        "                        <a class=\"profDescription\" href=\"prof_detail.jsp?prof_id=" + object.prof_id + "\">--More Details about " + object.name + "--</a>\n" +
                        "                    </div>\n" +
                        "                </li>\n" +
                        "            </ul><hr/>");
                });

            })
        })
    </script>
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
                        <li><a href="Document/4-year-plan.pdf"><span>Education Plan</span></a></li>
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

<div style="font-size: 35px; text-align: center" class="title">Professors Team</div>
<h3 class="shortcode">.</h3>


<div class="page_one">
    <div class="contant">
        <div class="left" id="prof_list">
            <ul class="profBlock">
                <li>
                    <div class="profImg"><img src="images/photo1.png" class="photo1" alt=""></div>
                    <div class="text1">
                        <p class="profName">Larry Brown</p>
                        <br/>
                        <p class="profDescription">Hello everyone, I am Larry Brown, the dean of the department of
                            Computer Science and Technology. Hope we can have a good semester. Hello everyone, I am
                            Larry Brown, the dean of the department of
                            Computer Science and Technology. Hope we can have a good semester. Hello everyone, I am
                            Larry Brown, the dean of the department of
                            Computer Science and Technology. Hope we can have a good semester. </p>
                        <br/>
                        <a class="profDescription" href="#">--More Details--</a>
                    </div>
                </li>
            </ul>

            <hr/>
        </div>
    </div>

<%--    <h3 class="shortcode">.</h3>--%>

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
                <div class="address"><img src="images/phone.png" alt="" width="14" height="18"/> <strong>Phone:</strong>
                    +86
                    (0) 577 5587 0000
                </div>
                <div class="address"><img src="images/mail.png" alt="" width="15" height="12"/> <strong>Email:</strong>
                    <a
                            href="mailto:wku@wku.edu.cn">wku@wku.edu.cn</a>, <a href="mailto:cst@wku.edu.cn">
                        cst@wku.edu.cn</a></div>
            </div>
            <div class="footer-details">
                <h4>Wechat Accounts</h4>
                <div class="Stream">
                    <a href="images/footImg2.png"><img src="images/footImg2.png" style="width: 65px; height: 65px"
                                                       alt=""/></a>
                    <a href="images/footImg1.jpg"><img src="images/footImg1.jpg" style="width: 65px; height: 65px"
                                                       alt=""/></a>
                    <a href="images/footImg3.jpg"><img src="images/footImg3.jpg" style="width: 65px; height: 65px"
                                                       alt=""/></a>
                </div>
            </div>
            <div class="footer-details no-margin">
                <h4>Learn More about WKU</h4>
                <a href="http://www.wku.edu.cn" style="color: whitesmoke"><p>If you want to learn more about
                    Wenzhou-Kean University, welcome to visit WKU official website</p></a>
            </div>

            <!-- Footer Info Part Start-->
            <div class="Finfo">
                <div class="copyright">&copy; Designed By <a href="tutor.jsp">Aska Hou (Class 2018)</a>, instructed by
                    <a href="prof_detail.jsp?prof_id=18"> Dr.Hemn Barzan Abdalla </a>. Copyright &copy; 2021.WKU CST All
                    rights reserved.
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

