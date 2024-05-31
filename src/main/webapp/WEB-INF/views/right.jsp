<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<script>
   function bookSearch(){ //자바의 정석
      //alert("Book Search"); // ?
      let bookname=document.getElementById("bookname").value;
      //alert(bookname); // key노출
      // fetch("https://dapi.kakao.com/v3/search/book?target=title&query="+encodeURIComponent(bookname),{
      //         method : "GET",
      //         headers : { "Authorization":"KakaoAK 9bc81f16e40c74c5c91a5f0d8f80670a" }
      //       })
      fetch("http://localhost:8081/cart/api/search/"+encodeURIComponent(bookname))
      .then(resp=>{
          if(!resp.ok){
             throw new Error("Network response was not ok");
          }
          return resp.json();
         })
      .then(books=>{
         let blist="<table class='table table-hover'>";
         blist+="<thead>";
         blist+="<tr>";
         blist+="<th>제목</th>";
         blist+="<th>이미지</th>";
         blist+="<th>가격</th>";
         blist+="</tr>";
         blist+="</thead>";
         blist+="<tbody>";
         books.documents.forEach(function(book){
             let imageUrl=book.thumbnail;
             let price=book.price;
             let url=book.url;
             let title=book.title;
             blist+="<tr>";
             blist+="<td>"+title+"</td>";
             blist+="<td><a href='"+url+"'><img src='"+imageUrl+"' width='50px' height='60px'/></a></td>";
             blist+="<td>"+price+"</td>";
             blist+="</tr>";
         });
         blist+="</tbody>";
         blist+="</table>";
         document.getElementById("bookList").innerHTML=blist;
      })
      .catch(error=>{
         console.log(error);
      });
   }
</script>
<div class="card" style="min-height: 500px;max-height: 1000px;">
   <div class="card-body">
     <h4>BOOK SEARCH</h4>
     <div class="input-group mb-3">
             <input type="text" class="form-control" id="bookname" placeholder="Search"/>
             <div class="input-group-append">
               <a type="button" class="btn btn-secondary" id="search" onclick="bookSearch()">Go</a>
             </div>
      </div>
      <div class="loading-progress" style="display: none;">
        <div class="spinner-border text-secondary" role="status">
          <span class="sr-only">Loading...</span>
        </div>
      </div>
      <div id="bookList" style="overflow: scroll; height: 500px; padding: 10px">
         여기에 검색된 책 목록을 출력하세요.
      </div>
   </div>
</div>