<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id="formsContent">
	<!-- Form container -->
	<form id="teamEditForm" class="form-horizontal" autocomplete="off" method="POST" action="">
	<legend><fmt:message key="domain.team.edit.legend"/></legend>
		<div class="control-group">
			<label class="control-label" for="id"><fmt:message key="domain.team.column.id"/><em>*</em></label>
			<div class="controls">
				<input type="text" id="id" name="id" readOnly="true" value="${crudObj.id}" maxlength="100" data-reset="${crudObj.id}">
				<span class="help-inline"></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="teamName"><fmt:message key="domain.team.column.teamName"/><em>*</em></label>
			<div class="controls">
				<input type="text" id="teamName" name="teamName" value="${crudObj.teamName}" maxlength="100" placeholder="Role Name"  data-reset="${crudObj.teamName}">
				<span class="help-inline"></span>
			</div>
		</div>
		<div class="form-actions">
			<button id="saveButton" type="submit" class="btn btn-primary"><fmt:message key="button.operation.save"/> <fmt:message key="domain.team"/></button>
			<a href="${pageContext.request.contextPath}/domain/team/update/${crudObj.id}" id="resetButton" class="btn"><fmt:message key="button.operation.reset"/></a>
			<a href="${pageContext.request.contextPath}/domain/teams/list" id="cancelButton" class="btn"><fmt:message key="button.operation.cancel"/></a>
		</div>		
	</form>
</div>