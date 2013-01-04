<!--<form action="update" method="post">--> <!-- method post added -->
<form action="<c:url value="/products/${product.id }"/>" method="POST">
	<fieldset>
		<legend>Edit Product</legend>
		
		<!--<input type="hidden" name="product.id" value="${product.id }" />-->
		
		<label for="name">Name:</label> 
		<input id="name" type="text" name="product.name" value="${product.name }" /> 
		
		<label for="description">Description:</label>
		<textarea id="description" name="product.description">
			${product.description }
		</textarea>
		
		<label for="price">Price:</label> 
		<input id="price" type="text" name="product.price" value="${product.price }" />
		
		<label for="amount">Amount:</label> 
		<input id="amount" type="text" name="product.amount" value="${product.amount }" />
		
		<!--<button type="submit">Send</button>-->
		
		<!--  
		<button type="submit" name="_method" value="PUT">
			Send
		</button>
		-->
		
		<!-- cross browser solution -->
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="Send"/>
	</fieldset>
</form>