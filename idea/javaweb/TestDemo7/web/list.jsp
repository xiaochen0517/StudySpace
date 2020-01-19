<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>
    <link href="css/reset.css" rel="stylesheet">
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(id) {
            if (confirm("是否确认删除！")) {
                location.href = "${pageContext.request.contextPath}/deluser?id=" + id;
            }
        }

        function delSelected() {
            if (confirm("是否确认删除！")) {
                document.getElementById("selectForm").submit();
            }
        }

        function pageSelected(pageCount) {
            if (pageCount <= 0)
                alert("当前已是第一页！");
            else if (pageCount > ${page.allPageCount})
                alert("当前已是最后一页！");
            else
                location.href = "${pageContext.request.contextPath}/userservlet?pageCount=" +
                    pageCount + "&rowsCount=" + 10;
        }

        function searchUser(pageCount) {
            var name = document.getElementById("name").value;
            var address = document.getElementById("address").value;
            var email = document.getElementById("email").value;
            //url
            var urlstr = "${pageContext.request.contextPath}/userservlet?";
            if (pageCount <= 0)
                alert("当前已是第一页！");
            else if (pageCount > ${page.allPageCount})
                alert("当前已是最后一页！");
            else
                urlstr += "pageCount=" + pageCount + "&rowsCount=" + 10;

            console.log(name + "|" + address + "|" + email);
            if (name != "")
                urlstr += "&name=" + name;
            if (address != "")
                urlstr += "&address=" + address;
            if (email != "")
                urlstr += "&email=" + email;
            location.href = urlstr;
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;">
        <div class="form-inline">
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" class="form-control inputl" id="name" value="${search.name}">
            </div>
            <div class="form-group">
                <label for="address">籍贯</label>
                <input type="email" class="form-control inputl" id="address" value="${search.address}">
            </div>
            <div class="form-group">
                <label for="email">邮箱</label>
                <input type="email" class="form-control inputl" id="email" value="${search.email}">
            </div>
            <button class="btn btn-default" onclick="searchUser(1)">查询</button>
        </div>
    </div>

    <div style="float: right;margin-bottom: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:delSelected()">删除选中</a>
    </div>

    <form id="selectForm" action="${pageContext.request.contextPath}/delselected" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>
                    <input type="checkbox">
                </th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            <c:if test="${not empty users}">
                <c:forEach items="${users}" var="user" varStatus="u">
                    <tr>
                        <td>
                            <input type="checkbox" name="uid" value="${user.id}">
                        </td>
                        <td>${u.count}</td>
                        <td>${user.name}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/finduser?id=${user.id}">修改</a>&nbsp;
                            <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${empty users}">
                <tr>
                    <td colspan="9">无数据</td>
                </tr>
            </c:if>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="javascript:searchUser(${page.locaPageCount-1})" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${page.allPageCount}" var="count">
                    <li
                            <c:if test="${page.locaPageCount == count}">
                                class="active"
                            </c:if>
                    ><a href="javascript:searchUser(${count})">${count}</a></li>
                </c:forEach>
                <li>
                    <a href="javascript:searchUser(${page.locaPageCount+1})" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="margin-left: 10px; font-size: 20px">
                    共${page.allRowsCount}条，共${page.allPageCount}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
