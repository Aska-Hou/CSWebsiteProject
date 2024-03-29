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
    <title>WKU CS Department</title>

    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' type='text/css'>
    <!--For images carousel-->
    <script src="https://libs.baidu.com/jquery/1.4.2/jquery.min.js"></script>
    <%--    News 轮播加载--%>
    <script>
        $(function () {
            $.ajax({
                url: "index/showIndexSliderImage",
                async: false,
                method: "get",
                success: function (data) {
                    $("#imgSlides").empty();
                    $.each(data, function (index, object) {
                        if (object.news_id == null) {
                            $("#imgSlides").append("<li style=\"background:#f9f9f9;\">\n" +
                                "                    <div style=\"width: 100%\">\n" +
                                "<img class=\"indexImg\" src=\"/CSWebsite/" + object.img + "\"/>\n" +
                                "                    </div>\n" +
                                "                </li>");
                        } else {
                            $("#imgSlides").append("<li style=\"background:#f9f9f9;\">\n" +
                                "                    <div style=\"width: 100%\">\n" +
                                "                        <a href=\"news_detail.jsp?news_id=" + object.news_id + "\"> <img class=\"indexImg\" src=\"/CSWebsite/" + object.img + "\"/></a>\n" +
                                "                    </div>\n" +
                                "                </li>");
                        }
                    })
                }
            })

            $.ajax({
                url: "news/showRecentNews",
                async: false,
                method: "post",
                success: function (data) {
                    $("#news_list").empty();
                    $.each(data, function (index, object) {
                        $("#news_list").append("<li>\n" +
                            "                    <a style='font-size: 12px;width: 320px; height: 263px' href=\"news_detail.jsp?news_id=" + object.news_id + "\">\n" +
                            "                        <img style=\"width: 285px;height: 173px\" border=\"0\" src=\"/CSWebsite/" + object.photo + "\" alt=\"\"/>" + object.title +
                            "                        <span>" + new Date(object.date).format("yyyy-MM-dd") + "</span>\n" +
                            "                    </a>\n" +
                            "                </li>");
                    });
                }
            });
        });

        Date.prototype.format = function (fmt) {
            var o = {
                "M+": this.getMonth() + 1,                 //月份
                "d+": this.getDate(),                    //日
                "h+": this.getHours(),                   //小时
                "m+": this.getMinutes(),                 //分
                "s+": this.getSeconds(),                 //秒
                "q+": Math.floor((this.getMonth() + 3) / 3), //季度
                "S": this.getMilliseconds()             //毫秒
            };
            if (/(y+)/.test(fmt)) {
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            }
            for (var k in o) {
                if (new RegExp("(" + k + ")").test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                }
            }
            return fmt;
        }

    </script>
    <script type="text/javascript" src="js/jquery.carousel.js"></script>
    <!--For Slider-->
    <script type='text/javascript' src='js/superfish3d36.js?ver=3.3.1'></script>
    <script type='text/javascript' src='js/jquery.custom5152.js?ver=1.0'></script>
    <!--For Asyncslider-->
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <!--For FlexSlider -->
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
    <script src="js/jquery.flexslider-min.js"></script>
    <script>
        $(function () {

            $.post("prize/showIndexPrize", {}, function (data) {
                $("#prize_list").empty();
                $.each(data, function (index, object) {
                    $("#prize_list").append("<div class=\"blogPost\">\n" +
                        "                <div class=\"thumb-img\">\n" +
                        "                    <a href=\"news_detail.jsp?news_id=" + object.news_id + "\"><img style='width: 59px; height: 59px' src=\"/CSWebsite/" + object.photo + "\" alt=\"\" border=\"0\"/></a>\n" +
                        "                </div>\n" +
                        "                <div class=\"post-cont\">\n" +
                        "                    <p>" + object.name + "</p>\n" +
                        "                    <span class=\"date\">" + new Date(object.date).format("yyyy-MM-dd") + "</span>\n" +
                        "                </div>\n" +
                        "            </div>");
                })
            });

            $.post("publication/showIndexPublication", {}, function (data) {
                $("#publication_list").empty();
                $.each(data, function (index, object) {
                    $("#publication_list").append("<div class=\"tweet-box\">\n" +
                        "                <p><a href=\"" + object.website + "\">" + object.title + "</a> <span class=\"time\">" + new Date(object.date).format("yyyy-MM-dd") + "  " + object.area + "</span></p>\n" +
                        "            </div>");
                })
            })

        })
    </script>
</head>

<body>

<!-- Header Start-->
<div class="header-wrapper-light">
    <div id="header">
        <a href="http://www.wku.edu.cn">
            <img src="images/logo2.jpg" style="height: 77px" id="logoImg1" alt=""/>
            <img src="images/logoImg3.png" style="height: 77px" id="logoImg2" alt=""/>
        </a>
        <a href="index.jsp"><img src="images/CSDepartmentLogo.png" id="cslogo" alt=""/></a>

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
                        <li><a href="gallery_list.jsp"><span>Gallery</span></a></li>
                        <li><a href="center_list.jsp"><span>Research Center</span></a></li>

                    </ul>
                </li>
                <li><a href="tutor.jsp"><span>Student & Alumni</span></a></li>
            </ul>
            <!-- END #primary-nav -->
        </div>
    </div>

    <!-- Slider Start-->
    <div id="slider">
        <div class="flexslider">
            <ul class="slides" id="imgSlides">

                <!-- Slides-->
                <li style="background:#224e9c;">
                    <div style="width: 100%">
                        <img class="indexImg" src="images/rollImage/image2.png"/>
                    </div>
                </li>

                <li style="background:#224e9c;">
                    <div style="width: 100%">
                        <img class="indexImg" src="images/rollImage/image3.jpg"/>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- Middle Part Start-->
<div id="middle-wrapper">
    <div class="Rwork">
        <h3>Recent News</h3>
        <ul class="gallery clearfix" style="display:none">
        </ul>
        <div id="my-carousel-2" class="carousel module gallery clearfix">
            <ul id="news_list">
                <%--                    285 * 173--%>
                <li>
                    <a href="#">
                        <img style="width: 285px;height: 173px"
                             src="images/img1.jpg" alt="" border="0"/>
                        News1
                        <span>Description 1</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <img src="images/img1.jpg" alt=""/>
                        News2
                        <span>Description 2</span>
                    </a>
                </li>

                <li>
                    <a href="#">
                        <img src="images/img1.jpg" alt="" border="0"/>
                        News3
                        <span>Description 3</span>
                    </a>
                </li>

                <li>
                    <a href="images/big-img.jpg">
                        <img src="images/img1.jpg" alt="" border="0"/>
                        News4
                        <span>Description 4</span>
                    </a>
                </li>

                <li>
                    <a href="images/big-img.jpg">
                        <img src="images/img1.jpg" alt="" border="0"/>
                        News5
                        <span>Description 5</span>
                    </a>
                </li>

            </ul>
        </div>
    </div>

    <div class="divider" style="margin-top: 50px">
        <div class="lighting"></div>
    </div>
    <br/>

    <div class="webdesign">
        <a href="about.jsp"><h3>About WKU CS Department</h3></a>
        <p>Wenzhou-Kean University Computer Science Department belongs to WKU College of Science and Technology and we offers an undergraduate major leading to a B.S. degree.. There are 11 faculties and more than 200 students currently in our department.</p>
    </div>

    <div class="webdesign">
        <a href="https://wku.edu.cn/wp-content/uploads/2018/09/2018-2019-Undergraduate-Catalog-of-Wenzhou-Kean-University-as-of-2019.4.4.pdf" target="_blank"><h3>Education Program</h3></a>
        <p>WKU Computer science and technology majors train students to master a solid theoretical foundation, attach importance to the combination of theory and practice, highlight students' practical ability, and encourage students to participate in various studies that combine interest and academics.</p>
    </div>

    <div class="webdesign">
        <h3 class="blue">Details - Education 4-year Plan</h3>
        <p>If you want to see more our education program, click the button below for downloading the CS 4-year plan.</p>
        <br/>
        <div class="viewPro"><a href="Document/4-year-plan.pdf" download="Document/4-year-plan.pdf" class="btn">Download
            4-year Plan</a></div>
    </div>

    <div class="divider1" style="margin-top: 70px"></div>
    <div class="Fblog">
        <h3 class="blue">Competition Prize</h3>
        <div id="prize_list">
            <div class="blogPost">
            </div>

        </div>

        <a href="prize_list.jsp" class="view-blog">View All Prize &rarr;</a></div>

    <div class="tweets">
        <h3>Academic Publications</h3>

        <div id="publication_list">
            <div class="tweet-box">
                <p><a href="">Author 1</a> <span class="time">Time 1</span></p>
            </div>
        </div>
        <a href="publication_list.jsp" class="view-blog">View All Publications</a></div>
</div>

<div class="testimonial no-margin">
    <h3>Department Chairman Wish: </h3>
    <div class="client-box">
        <div class="client-testimonial">
            <p> To All WKU CS Student: Don't pay too much attention to your GPA. The aim of going to university is to
                get the knowledge instead of High GPA.</p>
        </div>
        <div class="client-bg"><span class="name">Dr Tiffany Tang</span>, Associate Professor of WKU</div>
    </div>
    <div class="client-box">
        <div class="client-testimonial">
            <p>Introduction to CS Department Introduction to CS Department Introduction to CS Department Introduc
                Introduction to CS Department Introduction to CS Department</p>
        </div>
        <div class="client-bg"><span class="name">Dr Tiffany Tang</span>, Associate Professor of WKU</div>
    </div>
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
                    href="mailto:wku@wku.edu.cn">wku@wku.edu.cn</a>, <a href="mailto:cst@wku.edu.cn"> cst@wku.edu.cn</a>
            </div>
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
            <a href="http://www.wku.edu.cn" style="color: whitesmoke"><p>If you want to learn more about Wenzhou-Kean
                University, welcome to visit WKU official website</p></a>
        </div>

        <!-- Footer Info Part Start-->
        <div class="Finfo">
            <div class="copyright">&copy; Designed By <a href="tutor.jsp">Aska Hou (Class 2018)</a>, instructed by <a
                    href="prof_detail.jsp?prof_id=18"> Dr.Hemn Barzan Abdalla </a>. Copyright &copy; 2021.WKU CST All
                rights reserved.
            </div>
        </div>
    </div>
</div>
</body>

</html>
