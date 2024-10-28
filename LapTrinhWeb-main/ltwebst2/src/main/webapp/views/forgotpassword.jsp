<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/taglib.jsp"%>

          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Forgot Your Password?</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                <c:if test="${alert != null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>
                  <form action="${pageContext.request.contextPath}/forgotpassword" method="post" class="form-horizontal form-without-legend" role="form">                    
                    <div class="form-group">
                      <label for="uname" class="col-lg-4 control-label">User Name <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="username" name="uname" required>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="email" name="email" required>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="psw" class="col-lg-4 control-label">New Password <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="psw" required>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="psw-repeat" class="col-lg-4 control-label">Confirm Password <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="confirm-password" name="psw-repeat" required>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-5">
                        <button type="submit" class="btn btn-primary">Send</button>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Enter the e-mail address associated with your account. Click submit to have your password e-mailed to you.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->