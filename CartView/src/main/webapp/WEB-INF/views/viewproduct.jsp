<div class="container">
					  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
  <div ng-app="myApp" ng-controller="dataCtrl">
  
Enter Product Name:  <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th> Product Id</th>
    <th> Name</th>
    <th> Brand</th>
    <th> Price</th>
    <th> Product Image</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.productId}}</td>
            <td>{{ resource.name}}</td>
            <td>{{ resource.brand}}</td>
            <td>{{ resource.price}}</td>
            <td><img src="./resources/images/{{resource.productId}}.jpg" style="width: 200px;height:150px"></td>
            <td><a href="deleteProduct?id={{resource.productId}}">Delete</a></td>
            <td><a href="editItem?id={{resource.productId}}">Edit</a></td>
        </tr>    
    </table>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${json};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
</div>