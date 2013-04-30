'use strict';

/* App Module */

angular.module('bookstore', ['ngResource','bookDetailServiceModule']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.
      when('/booklist', {templateUrl: 'views/booklist.html',   controller: BookListCtrl}).
      when('/bookdetail/:id', {templateUrl: 'views/book-detail.html',   controller: BookDetailCtrl}).
      when('/newbook', {templateUrl: 'views/new-book.html',   controller: NewBookCtrl}).
      otherwise({redirectTo: '/booklist'});
}]).config(['$httpProvider', function($httpProvider) {
    delete $httpProvider.defaults.headers.common["X-Requested-With"]
}]);
