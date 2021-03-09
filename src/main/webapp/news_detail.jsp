<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/31
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>News Detail</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--For images carousel-->
    <script src="https://libs.baidu.com/jquery/1.4.2/jquery.min.js"></script>
    <!--For Portfolio-->
    <script src="js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.quicksand.js"></script>
    <script type="text/javascript" src="js/setting.js"></script>
    <!--For Menu-->
    <script type='text/javascript' src='js/superfish3d36.js?ver=3.3.1'></script>
    <script type='text/javascript' src='js/jquery.custom5152.js?ver=1.0'></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type='text/javascript' src='js/jquery-ui-1.8.5.custom.min.js'></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
    <script>
        $(function () {
            var id = getQueryString("news_id");
            $.post("news/showDetail", {news_id: id}, function (data) {
                var detail = $("#detail");
                detail.empty();
                detail.append("<div class=\"news_title\">"+ data.title +"</div>\n" +
                    "    <li><div class=\"news_img_block\"><img src=\"/CSWebsite/"+ data.photo +"\" class=\"news_img\" alt=\"\"/></div>\n" +
                    "    <div class=\"news_content\">\n" +
                    "        <img src=\"images/quote.png\" style=\"width: 40px\" alt=\"\"/>\n" +
                    "        <span class=\"news_abstract\">Abstract:"+ data.abstractContent +"</span></div></li>\n" +
                    "\n" +
                    "        <div style='margin-top: 450px; font-size: 16px; line-height: 20px' <p style='margin-top: 200px'><br/>"+ data.content +"</p>\n" +
                    "    </div>")
            })
        });

        function getQueryString(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        };
    </script>
</head>


<body>


<!-- Header Start-->
<div class="header-wrapper1">
    <div id="header">
        <a href="http://www.wku.edu.cn">            <img src="images/logo2.jpg" id="logoImg1" alt=""/>
            <img src="images/logo3.jpg" id="logoImg2" alt=""/></a>
        <img src="images/CSDepartmentLogo.png" id="cslogo" alt=""/>

        <!-- Top Menu Start-->
        <div id="primary-nav">
            <ul id="menu-primary-menu" class="sf-menu">
                <li><a href="index.jsp"><span>Home</span></a></li>

                <li><a href="news_list.jsp"><span>News</span></a></li>

                <li><a href="#" class="sf-with-ul">About Us</a>
                    <ul class="sub-menu">
                        <li><a href="about.jsp"><span>About Us</span></a></li>
                        <li><a href="full-width.html"><span>Education Plan</span></a></li>
                    </ul>
                </li>

                <li><a href="#" class="sf-with-ul">Academic</a>
                    <ul class="sub-menu">
                        <li><a href="prof_list.jsp"><span>Faculty Team</span></a></li>
                        <li><a href="publication_list.jsp"><span>Publication</span></a></li>
                        <li><a href="prize_list.jsp"><span>Prize</span></a></li>
                    </ul>
                </li>

                <li><a href="tutor.jsp"><span>Tutor</span></a></li>

                <li><a onclick="alert('Waiting for Development')" href="#"><span>My CS</span></a></li>
            </ul>
            <!-- END #primary-nav -->
        </div>
    </div>
</div>

<br/>
<div class="newsMain" id="detail">

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
                    href="#">wku@wku.edu.cn</a></div>
        </div>
        <div class="footer-details">
            <h4>Photo Stream</h4>
            <div class="Stream">
                <a href="#"><img src="images/photo1.jpg" alt=""/></a>
                <a href="#"><img src="images/photo1.jpg" alt=""/></a>
                <a href="#"><img src="images/photo1.jpg" alt="" class="no-margin"/></a>
            </div>
        </div>
        <div class="footer-details no-margin">
            <h4>Other Content</h4>
            <p>Other Content Other Content Other ContentOther Content Other Content Other Content Other Content</p>
        </div>

        <!-- Footer Info Part Start-->
        <div class="Finfo">
            <div class="copyright">&copy; Designed By Aska. Copyright &copy; 2020.Company name All rights reserved.
            </div>
        </div>
    </div>
</div>

</body>
</html>
