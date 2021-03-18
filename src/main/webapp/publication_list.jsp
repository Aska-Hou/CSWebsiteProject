<%--
  Created by IntelliJ IDEA.
  User: Aska
  Date: 2021/1/4
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Academic Publication</title>
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
    <!--    Paging-->
    <script src="https://cdn.bootcdn.net/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
    <link rel="stylesheet"
          href="https://formden.com/static/assets/demos/bootstrap-iso/bootstrap-iso/bootstrap-iso.css"/>    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>

        var currentPage = 0;
        var lastPage = 0;

        $(function () {
            jumpToPage(1);
        })

        //跳转指定页码
        function jumpToPage(page) {
            window.scrollTo(0, 0);
            showContent(page);
            showPage(page);
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

        //展示页码
        function showPage(page) {
            var pageList = $("#pageList");
            pageList.empty();
            $.post("publication/showPageList", null, function (data) {
                lastPage = data.totalPage;

                var content = "";
                if (page == 1) {
                    content += "<li class=\"disabled\">";
                }
                else {
                    content += "<li>\n";
                }
                content += "                        <a href=\"#\" onclick='prevPage()' aria-label=\"Previous\">\n" +
                    "                            <span aria-hidden=\"true\">&laquo;</span>\n" +
                    "                        </a>\n" +
                    "                    </li>";

                for (var i = 1; i <= data.totalPage; i++){
                    if (page == i) {
                        content += "<li class=\"active\"><a href='#' onclick=\"jumpToPage("+ i +")\">"+ i +"</a></li>";
                    }
                    else {
                        content += "<li><a href='#' onclick=\"jumpToPage("+ i +")\">"+ i +"</a></li>";
                    }
                }

                if (page == data.totalPage) {
                    content += "<li class='disabled'>";
                }
                else {
                    content += "<li>";
                }

                content += "                        <a href=\"#\" onclick='nextPage()' aria-label=\"Next\">\n" +
                    "                            <span aria-hidden=\"true\">&raquo;</span>\n" +
                    "                        </a>\n" +
                    "                    </li>";
                pageList.append(content);
            });
        }

        //展示该页码的内容
        function showContent(page) {
            var list = $("#list");
            list.empty();
            $.post("publication/showPublication", {currentPage: page}, function (data) {
                $.each(data, function (index, object) {
                    list.append("<ul class=\"paperUL\">\n" +
                        "                <img src=\"images/quote.png\" class=\"paper_img\"/>\n" +
                        "                <br/>\n" +
                        "                <li><span class=\"paperTitle\"> Title: </span> <span class=\"paperTitle\">"+ object.title +"</span>\n" +
                        "                </li>\n" +
                        "                <li><span class=\"paperTitle\"> Author: </span> <span class=\"paper_subTitle\"><a href=\"#\">"+ object.author +"</a> </span>\n" +
                        "                </li>\n" +
                        "                <li><span class=\"paperTitle\"> Publication Date: </span> <span class=\"paper_subTitle\">"+ object.date +"</span>\n" +
                        "                </li>\n" +
                        "                <li><span class=\"paperTitle\"> Area:  </span> <span class=\"area\">"+ object.area +"</span></li>\n" +
                        "                <li><span class=\"paperTitle\"><a\n" +
                        "                        href=\""+ object.website +"\" class=\"paper_subTitle\"> Publish Website & More Details </a></span></li>\n" +
                        "            </ul>\n" +
                        "            <img src=\"images/divider.png\" style=\"width: 100%\"/>\n")
                });
            })
        }
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

<div class="title">Paper and Publication</div>
<h3 class="shortcode">'</h3>

<div class="paperPage">
    <div class="paperlist">
        <div class="paper" id="list">
            <ul class="paperUL">
                <img src="images/quote.png" class="paper_img"/>
                <br/>
                <li><span class="paperTitle"> Title: </span> <span class="paperTitle">A Customizable Calculator Application with 3D-Printed Cover for the Visually Impaired in China</span>
                </li>
                <li><span class="paperTitle"> Author: </span> <span class="paper_subTitle"><a href="#">Pinata Winoto</a> </span>
                </li>
                <li><span class="paperTitle"> Publication Date: </span> <span class="paper_subTitle">23 June 2017</span>
                </li>
                <li><span class="paperTitle"> Area:  </span> <span class="area">Data Science</span></li>

                <br/>
                <li><span class="paperTitle"> Abstract: </span>
                    <div class="content">To date, a wide variety of applications are developed and available in iTunes
                        App Store, Google Play and Windows App Market. However, the visually impaired are still unable
                        to enjoy most of them because of the non-optimized design of these applications for them. Though
                        some mobile operating systems provide auditory assistive functions, slow and tedious interaction
                        style lead to a poor user experience. Therefore, it is necessary to design specific applications
                        for the visually impaired, providing not only basic functions, but a good user experience as
                        well. To achieve the goal, in this research, we focused on a frequently implemented task on the
                        mobile phones. Specifically, a Windows Phone calculator application for visually impaired has
                        been designed. Similar to a typical calculator, it allows users to perform some basic
                        calculations such as addition and multiplication. However, unlike typical calculators, it has a
                        special layout and audio clues designed for the visually impaired. To complement the
                        application, we have also designed a 3D-printed cover with holes on it, serving as the tactile
                        interface for the application. The application is highly customizable so that users can reassign
                        each button according to their preferences. The entire solution, including the Windows Phone
                        calculator application and the 3D-printed cover, can provide visually impaired users the basic
                        function of calculations as well as a rich user experience. With this solution, a considerable
                        improvement with respect to the operational speed was found during a simulation test.
                        A pilot experiment has been designed to test the working efficiency using blindfolded users.
                    </div>
                </li>
                <li><span class="paperTitle"> Publish Website: </span> <span class="content"><a
                        href="#" class="paper_subTitle">Springer Link</a></span></li>
            </ul>
            <img src="images/divider.png" style="width: 100%"/>

            <ul class="paperUL">
                <img src="images/quote.png" class="paper_img"/>
                <br/>
                <li><span class="paperTitle"> Title: </span> <span class="paperTitle">A Customizable Calculator Application with 3D-Printed Cover for the Visually Impaired in China</span>
                </li>
                <li><span class="paperTitle"> Author: </span> <span class="paper_subTitle"><a
                        href="#">Pinata Winoto</a> </span>
                </li>
                <li><span class="paperTitle"> Publication Date: </span> <span class="paper_subTitle">23 June 2017</span>
                </li>
                <li><span class="paperTitle"> Area:  </span> <span class="area">Data Science</span></li>
                <li><span class="paperTitle"> Abstract: </span>
                    <div class="content">To date, a wide variety of applications are developed and available in iTunes
                        App Store, Google Play and Windows App Market. However, the visually impaired are still unable
                        to enjoy most of them because of the non-optimized design of these applications for them. Though
                        some mobile operating systems provide auditory assistive functions, slow and tedious interaction
                        style lead to a poor user experience. Therefore, it is necessary to design specific applications
                        for the visually impaired, providing not only basic functions, but a good user experience as
                        well. To achieve the goal, in this research, we focused on a frequently implemented task on the
                        mobile phones. Specifically, a Windows Phone calculator application for visually impaired has
                        been designed. Similar to a typical calculator, it allows users to perform some basic
                        calculations such as addition and multiplication. However, unlike typical calculators, it has a
                        special layout and audio clues designed for the visually impaired. To complement the
                        application, we have also designed a 3D-printed cover with holes on it, serving as the tactile
                        interface for the application. The application is highly customizable so that users can reassign
                        each button according to their preferences. The entire solution, including the Windows Phone
                        calculator application and the 3D-printed cover, can provide visually impaired users the basic
                        function of calculations as well as a rich user experience. With this solution, a considerable
                        improvement with respect to the operational speed was found during a simulation test.
                        A pilot experiment has been designed to test the working efficiency using blindfolded users.
                    </div>
                </li>
                <li>
                    <span class="paperTitle"> Publish Website: </span>
                    <span class="content">
                    <a href="#" class="paper_subTitle">Springer Link</a>
                </span>
                </li>
            </ul>
        </div>
    </div>
</div>

<!--Paging-->
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

<h3 class="shortcode">.</h3>

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
