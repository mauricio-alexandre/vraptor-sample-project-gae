<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Amount</th>
			<th>Registration Date</th>
			<th>Update Date</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.name }</td>
				<td>${product.description }</td>
				<td>${product.price }</td>
				<td>${product.amount }</td>
				<td><fmt:formatDate value="${product.registrationDate }" pattern="dd/MM/yyyy hh:mm:ss" /></td>
				<td><fmt:formatDate value="${product.updateDate }" pattern="dd/MM/yyyy hh:mm:ss" /></td>
				<td><a href="<c:url value="/products/${product.id}"/>">Edit</a></td>
				<td>
					<form action="<c:url value="/products/${product.id}"/>" method="POST">
						<button class="link" name="_method" value="DELETE">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>