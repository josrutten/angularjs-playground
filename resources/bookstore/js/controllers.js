'use strict';

/* Controllers */

function BookListCtrl($scope, $http, bookDetailService) {
  $http.get('http://localhost:8888/bookstore/list/all.json').success(function(data) {
    $scope.booklist = data;
    console.log($scope.booklist);
  });
  // $scope.booklist = bookDetailService.query();
  // console.log($scope.booklist);
}

//PhoneListCtrl.$inject = ['$scope', '$http'];


function BookDetailCtrl($scope, $routeParams, bookDetailService) {
  $scope.book = bookDetailService.get({bookId:$routeParams.id});
  console.log($scope.book);
}

// function BookDetailCtrl($scope, $routeParams, $http) {
//   $http.get('json/' + $routeParams.id + '.json').success(function(data) {
//     $scope.book = data;
//   });
//   setTimeout(function() {
//     console.log("timeout reached");
//     console.log($scope.book, $scope.book.adress.straat);
//   }, 2000);
// }


//PhoneDetailCtrl.$inject = ['$scope', '$routeParams', '$http'];

function NewBookCtrl($scope, $http, $location, $route) {
// $scope.book = {
//     "title": $scope.title, 
//    	"author": $scope.autor, 
//     "price": $scope.price,
//    	"id": ""
// };

	$scope.createBook = function() {
    $http.post('http://localhost:8888/bookstore/save',$scope.book).success(function() {
   	  $location.path( "#/booklist");
    });
	};

  $scope.addReview = function () {
    var newReview = {
          newspaper: "", 
          comments: ""
        };
    if ($scope.book.reviews) {
      $scope.book.reviews.push(newReview);
    } else {
      $scope.book.reviews = [newReview];
    }
  }

}
