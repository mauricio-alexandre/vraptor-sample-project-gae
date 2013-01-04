<!--<form action="add" method="post">--> <!-- method post added -->
<form id="productsForm" action="<c:url value="/products"/>" method="POST">
	<fieldset>
		<legend>Add Product</legend>
		
		<label for="name">Name:</label>
		<input id="name" type="text" name="product.name"/>
		
		<label for="description">Description:</label>
		<textarea id="description" name="product.description"></textarea>
		
		<label for="price">Price:</label>
		<input id="price" type="text" name="product.price"/>
		
		<label for="amount">Amount:</label>
		<input id="amount" type="text" name="product.amount"/>
		
		<button type="submit">Send</button>
	</fieldset>
</form>