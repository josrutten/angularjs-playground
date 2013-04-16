'use strict';

/* Controllers */

function BookListCtrl($scope, $http, bookDetailService) {
  $http.get('http://localhost:8888/bookstore/list/all.json').success(function(data) {
    $scope.booklist = data.book;
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
