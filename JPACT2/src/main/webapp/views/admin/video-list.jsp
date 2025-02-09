<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<h2>Danh Sách Video</h2>

<a href="${pageContext.request.contextPath}/admin/video/add">Thêm video</a>

<table border="1">
    <thead>
        <tr>
            <th>STT</th>
            <th>Video ID</th>
            <th>Media</th> <!-- Thay đổi từ Images sang Media để bao gồm cả hình ảnh và video -->
            <th>Video Title</th>
            <th>Description</th>
            <th>Views</th>
            <th>Category</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listvideo}" var="video" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${video.videoid}</td>

                <!-- Hiển thị hình ảnh hoặc video -->
                <td>
                    <c:choose>
                        <c:when test="${fn:endsWith(video.poster, '.mp4')}">
                            <video width="320" height="240" controls>
                                <source src="${pageContext.request.contextPath}/image?fname=${video.poster}" type="video/mp4">Your browser does not support the video tag.
                            </video>
                        </c:when>
                        <c:otherwise>
                            <img src="${pageContext.request.contextPath}/image?fname=${video.poster}" height="100" alt="Poster Image" />
                        </c:otherwise>
                    </c:choose>
                </td>

                <td>${video.title}</td>
                <td>${video.description}</td>
                <td>${video.views}</td>
                <td>${video.category.categoryname}</td>

                <!-- Hiển thị trạng thái -->
                <td>${video.active == 1 ? 'Hoạt động' : 'Khóa'}</td>

                <!-- Các hành động sửa/xóa -->
                <td>
                    <a href="${pageContext.request.contextPath}/admin/video/edit?id=${video.videoid}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/admin/video/delete?id=${video.videoid}" 
                       onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>