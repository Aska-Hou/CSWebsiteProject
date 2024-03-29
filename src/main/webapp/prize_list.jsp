<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/4
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Competition Prize</title>
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
    <link rel="stylesheet"
          href="https://formden.com/static/assets/demos/bootstrap-iso/bootstrap-iso/bootstrap-iso.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
    <script>

        var currentPage = 0;
        var lastPage = 0;

        $(function () {
            jumpToPage(1);
        });

        function jumpToPage(page) {
            window.scrollTo(0, 0);
            showPage(page);
            showData(page);
            currentPage = page;
        }

        function nextPage() {
            if (currentPage != lastPage) {
                jumpToPage(currentPage + 1);
            }
        }

        function prevPage() {
            if (currentPage != 1) {
                jumpToPage(currentPage - 1);
            }
        }

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

        function showData(currentPage) {
            var list = $("#prize_list");
            list.empty();
            $.post("prize/showPrizeList", {currentPage: currentPage}, function (data) {
                $.each(data, function (index, object) {
                    list.append("<ul class=\"prizeBlock\">\n" +
                        "                <li class=\"prizeLine\">\n" +
                        "                    <div class=\"profImg\"><img src=\"/CSWebsite/" + object.photo + "\" class=\"photo1\" alt=\"\"></div>\n" +
                        "                    <div class=\"text1\">\n" +
                        "                        <p class=\"prizeName\">" + object.name + "</p>\n" +
                        "                        <br/>\n" +
                        "                        <p class=\"profDescription\">Time: " + new Date(object.date).format('yyyy-MM-dd') + "</p>\n" +
                        "                        <br/>\n" +
                        "                        <p class=\"profDescription\">Winner: " + object.winner + "</p>\n" +
                        "                        <br/>\n" +
                        "                        <a class=\"profDescription\" href=\"news_detail.jsp?news_id=" + object.news_id + "\">--More Details About This Prize--</a>\n" +
                        "                    </div>\n" +
                        "                </li>\n" +
                        "            </ul> <hr/>");
                })
            });
        }

        function showPage(page) {
            var pageList = $("#pageList");
            pageList.empty();
            $.post("prize/showPageList", null, function (data) {
                lastPage = data.totalPage;

                var content = "";
                if (page == 1) {
                    content += "<li class=\"disabled\">";
                } else {
                    content += "<li>\n";
                }
                content += "                        <a onclick='prevPage()' href=\"#\" aria-label=\"Previous\">\n" +
                    "                            <span aria-hidden=\"true\">&laquo;</span>\n" +
                    "                        </a>\n" +
                    "                    </li>";

                for (var i = 1; i <= data.totalPage; i++) {
                    if (page == i) {
                        content += "<li class=\"active\"><a href='#' onclick=\"jumpToPage(" + i + ")\">" + i + "</a></li>";
                    } else {
                        content += "<li><a href='#' onclick=\"jumpToPage(" + i + ")\">" + i + "</a></li>";
                    }
                }

                if (page == data.totalPage) {
                    content += "<li class='disabled'>";
                } else {
                    content += "<li>";
                }

                content += "                        <a href=\"#\" onclick='nextPage()' aria-label=\"Next\">\n" +
                    "                            <span aria-hidden=\"true\">&raquo;</span>\n" +
                    "                        </a>\n" +
                    "                    </li>";
                pageList.append(content);
            });
        }

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
        <a href="http://www.wku.edu.cn">
            <img src="images/logo2.jpg" style="height: 77px" id="logoImg1" alt=""/>
            <img src="images/logoImg3.png" style="height: 77px" id="logoImg2" alt=""/></a>
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
</div>

<div class="title" style="font-size: 35px; text-align: center">Competition Prize & Honor for Computer Science Department</div>
<h3 class="shortcode">'</h3>

<div class="page_one">
    <div class="contant">
        <div class="left" id="prize_list">
            <ul class="profBlock">
                <li class="prizeLine">
                    <div class="profImg"><img src="images/imageCup.png" class="photo1" alt=""></div>
                    <div class="text1">
                        <p class="profName">Microsoft Imagine Cup ---- First Prize</p>
                        <br/>
                        <p class="profDescription">Time: June 2016</p>
                        <br/>
                        <p class="profDescription">Winner: Person 1, Person 2, Person 3 </p>
                        <br/>
                        <a class="profDescription" href="#">--More Details--</a>
                    </div>
                </li>
            </ul>

            <hr/>

            <ul class="profBlock">
                <li class="prizeLine">
                    <div class="profImg"><img src="images/imageCup.png" class="photo1" alt=""></div>
                    <div class="text1">
                        <p class="profName">Microsoft Imagine Cup ---- First Prize</p>
                        <br/>
                        <p class="profDescription">Time: June 2016</p>
                        <br/>
                        <p class="profDescription">Winner: Person 1, Person 2, Person 3 </p>
                        <br/>
                        <a class="profDescription" href="#">--More Details--</a>
                    </div>
                </li>
            </ul>

            <hr/>

            <ul class="profBlock">
                <li class="prizeLine">
                    <div class="profImg"><img src="images/imageCup.png" class="photo1" alt=""></div>
                    <div class="text1">
                        <p class="profName">Microsoft Imagine Cup ---- First Prize</p>
                        <br/>
                        <p class="profDescription">Time: June 2016</p>
                        <br/>
                        <p class="profDescription">Winner: Person 1, Person 2, Person 3 </p>
                        <br/>
                        <a class="profDescription" href="#">--More Details--</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>


    <h3 class="shortcode"><!--Paging-->
        <div class="bootstrap-iso" style="margin-left: 300px">
            <div class="paging">
                <nav aria-label="Page navigation">
                    <ul class="pagination pagination-lg" id="pageList">
                        <li class="disabled">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </h3>

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
