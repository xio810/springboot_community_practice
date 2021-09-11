<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="완료 " />
<%@ include file="../common/head.jspf"%>

<section class="mt-5">
  <div class="container mx-auto px-3 flex justify-center">
    회원가입 완료 <br />
    로그인을 해주시기 바랍니다.
  </div>
  <div class="lo flex justify-center">
    <a href="/usr/member/login" class="btn mt-5">로그인</a>
  </div>
</section>

<%@ include file="../common/foot.jspf"%>
