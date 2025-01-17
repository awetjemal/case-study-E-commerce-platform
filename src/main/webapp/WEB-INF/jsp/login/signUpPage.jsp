<%--
  Created by IntelliJ IDEA.
  User: Awet_Mohammed
  Date: 1/16/2025
  Time: 7:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp"/>

<section class="bg-light1 pt-5 pb-5">
    <div class="container">
        <div class="row">
            <h1 class="m-0 text-center">Create Customer</h1>
        </div>
    </div>
</section>

<section class="bg-light2 pt-5 pb-5">
    <div class="container">
        <form action="/customer/createCustomer" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${form.customerId}"/>


            <div class="mb-3 row justify-content-center">
                <label for="companyName" class="col-sm-2 col-form-label">Company Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="companyName" name="companyName" value="${form.companyName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="firstName" name="firstName" value="${form.firstName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="lastName" name="lastName" value="${form.lastName}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="phone" name="phone" value="${form.phone}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="addressLine1" class="col-sm-2 col-form-label">Address Line 1</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="addressLine1" name="addressLine1" value="${form.addressLine1}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('companyName')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('companyName')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="city" class="col-sm-2 col-form-label">City</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="city" name="city" value="${form.city}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('city')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('city')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>

            <div class="mb-3 row justify-content-center">
                <label for="country" class="col-sm-2 col-form-label">Country</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="text" class="form-control" id="country" name="country" value="${form.country}">
                </div>
            </div>
            <c:if test="${bindingResult.hasFieldErrors('country')}">
                <div class="row justify-content-center">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-10 col-lg-6">
                        <c:forEach var="error" items="${bindingResult.getFieldErrors('country')}">
                            <dd class="mb-0 form_input_error">${error.getDefaultMessage()}</dd>
                        </c:forEach>
                    </div>
                </div>
            </c:if>
            <div class="mb-3 row justify-content-center">
                <label for="employeeId" class="col-sm-2 col-form-label">Employee</label>
                <div class="col-sm-10 col-lg-6">
                    <select name = "employeeId" id="employeeId" class="form-control">
                        <c:forEach var="employee" items="${employeesKey}">
                            <option
                                    value="${employee.id}"
                                    <c:if test="${form.employeeId eq employee.id}">selected</c:if>
                            >${employee.firstname} ${employee.lastname}</option>
                        </c:forEach>

                    </select>
                </div>
            </div>
            <div class="mt-3 row justify-content-center">
                <label for="upload" class="col-sm-2 col-form-label">Upload Image</label>
                <div class="col-sm-10 col-lg-6">
                    <input type="file" class="form-control" id="upload" name="upload">
                </div>
            </div>
            <div class="mb-3 row justify-content-center">
                <div class="col-sm-12 col-lg-8">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>

