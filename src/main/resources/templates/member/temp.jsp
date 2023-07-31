<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="width:100%; height:70%; overflow:auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="active table1" style=" border: 1px solid #dddddd">
<thead>
	<tr>
		<th style="text-align: center; vertical-align: middle;"></th>
		<th style="text-align: center; vertical-align: middle;">아이디</th>
		<th style="text-align: center; vertical-align: middle;">이름</th>
		<th style="text-align: center; vertical-align: middle;">Email</th>
		<th style="text-align: center; vertical-align: middle;">연락처</th>
		<th style="text-align: center; vertical-align: middle;">회원등급</th>
		<th style="text-align: center; vertical-align: middle;">가입일</th>
		<th style="text-align: center; vertical-align: middle;">최근접속일</th>
		<th style="text-align: center; vertical-align: middle;">삭제</th>
	</tr>
</thead>
<tbody>
	<c:choose>
		<c:when test="${list ==null }">
			<tr height="10">
				<td colspan="6">
					<p align="center">
						<b><span style="font-size: 9pt;">등록된 글이 없습니다.</span></b>
					</p>
				</td>
			</tr>
		</c:when>
		<c:when test="${list !=null }">
			<c:forEach var="item" items="${list }" varStatus="articleNum">
				<tr align="center">
					<!-- 다른곳에서 복붙하지말고 여기에 추가해주세요  -->
					<td width="5%">${articleNum.count}</td>
					<td width="15%">${item.userId}</td>
					<td width="14%">${item.userName}</td>
					<td width="20%">${item.userEmail}</td>
					<td width="15%">${item.userCp}</td>
					<td width="10%">${item.userGrade}</td>
					<td width="8%">${item.regDate}</td>
					<td width="8%">${item.joinDate}</td>
					<td width="5%" colspan="2"><input type="button" value="삭제" onclick="location.href='${contextPath}/admin/remove2.do?id=${item.userId}&katNo=${katTargetNo}'"></td>
			</c:forEach>
		</c:when>
	</c:choose>
</tbody>
</table>
</div>
