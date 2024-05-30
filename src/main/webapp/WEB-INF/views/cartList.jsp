<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script>
     function goCart(id){
       // get 방식 , QueryString
       // location.href="${cpath}/cartAdd?book_id="+id+"&customer_id="+${cus.id};
       // post방식, form 이용
       document.getElementById("bookId").value=id;
       document.getElementById("frm").submit(); // 전송
     }
     function goCancel(id){
       // get 방식, @PathVariable
       location.href="${cpath}/cartCancel/"+id;
     }
  </script>
</head>
<body>

  <div class="card">
    <div class="card-header">
	    <div class="jumbotron jumbotron-fluid">
		  <div class="container">
		    <h1>Spring Framework~~</h1>
		    <p>설명</p>
		  </div>
		</div>
    </div>
    <div class="card-body">
		<div class="row">
		  <div class="col-lg-2">
		   <jsp:include page="left.jsp"/>
		  </div>
		  <div class="col-lg-7">
            <div class="card">
              <div class="card-body">
                <h4 class="card-title">Cart List(${cus.username})</h4>
                <table class="table table-hover table-bordered mt-3">
                		        <thead>
                		          <tr>
                                      <th>제목</th>
                                      <th>가격</th>
                                      <th>수량</th>
                                      <th>저자</th>
                                      <th>페이지</th>
                                      <th>금액</th>
                                      <th>취소</th>
                		          </tr>
                		        </thead>
                		        <tbody>
                                 <c:forEach var="cart" items="${cartList}">
                		          <tr>
                                      <td>${cart.title}</td>
                                      <td>${cart.price}</td>
                                      <td>${cart.quantity}</td>
                                      <td>${cart.author}</td>
                                      <td>${cart.page}</td>
                                      <td><span class="badge badge-danger">${cart.amount}</span></td>
                		              <td><button class="btn btn-sm btn-secondary" onclick="goCancel(${cart.id})">Cancel</button></td>
                		          </tr>
                		          </c:forEach>
                		        </tbody>
                		     </table>
              </div>
            </div>
		  </div>
		  <div class="col-lg-3">
		    <jsp:include page="right.jsp"/>
		  </div>
		</div>
    </div>
    <div class="card-footer">빅데이터 플랫폼 개발자 과정_박매일</div>
  </div>
  <form id="frm" method="post" action="${cpath}/cartAdd">
      <input type="hidden" id="bookId" name="bookId"/>
      <input type="hidden" id="customerId" name="customerId" value="${cus.id}"/>
  </form>
</body>
</html>