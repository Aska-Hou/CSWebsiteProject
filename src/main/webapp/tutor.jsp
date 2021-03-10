<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/4
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Peer Tutor & Excellent Students</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--For images carousel-->
    <script src="https://libs.baidu.com/jquery/1.4.2/jquery.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                url: "tutor/showTutorList",
                method: "post",
                async: false,
                success: function (data) {
                    $("#tutor_list").empty();
                    $.each(data, function (index, object) {
                        $("#tutor_list").append("<li data-id=\"id-1\" data-type=\"" + object.grade.replace(" ", "") + "\" class=\"main\">\n" +
                            "                <a href=\"images/big-img.jpg\">\n" +
                            "                    <img src=\"/CSWebsite/" + object.photo + "\" style=\"width: 210px;height: 130px\" alt=\"\"/>\n" + object.name +
                            "  <span>" + object.grade + "</span>                  <span>" + object.experience + "</span>\n" +
                            "                </a>\n" +
                            "            </li>");
                    })
                }
            });
        })
    </script>

    <!--For Portfolio-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="js/setting.js"></script>
    <!--For Menu-->
    <script type='text/javascript' src='js/superfish3d36.js?ver=3.3.1'></script>
    <script type='text/javascript' src='js/jquery.custom5152.js?ver=1.0'></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <!--For prettyPhoto-->
    <link rel="stylesheet" href="css/prettyPhoto.css" type="text/css" media="screen"
          title="prettyPhoto main stylesheet"/>
    <script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
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

<!-- Middle Part Start-->
<div id="middle-wrapper">
    <!-- Left Section Start-->
    <div class="portleft">
        <h3>Catalog</h3>

        <ul class="portfolio_list spacermin10">
            <li class="active"><span>&rarr;</span> <a href="#" class="all">All</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2021">Class 2021</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2020">Class 2020</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2019">Class 2019</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2018">Class 2018</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2017">Class 2017</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2016">Class 2016 Alumni</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2015">Class 2015 Alumni</a></li>
            <li><span>&rarr;</span> <a href="#" class="Class2014">Class 2014 Alumni</a></li>
        </ul>

    </div>
    <!-- Right Section Start-->
    <div class="portright">
        <h3 style="margin-left: 0px">Peer Tutor & Excellent Students & Alumni</h3>
        <ul class="portfolio_contain gallery" id="tutor_list">
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

</body>
</html>

