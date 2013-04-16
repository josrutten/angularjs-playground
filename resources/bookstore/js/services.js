angular.module('bookDetailServiceModule', ['ngResource']).
    factory('bookDetailService', function($resource){
        return $resource("http://localhost:8888\:8888/bookstore/:path/:bookId.json", {bookId:'no_book_selected'}, {
        //return $resource("/bookstore/json/:bookId.json", {bookId:'no_book_selected'}, {
    get: {method:'GET', params:{path: 'detail'}},
    //query: {method:'GET', params:{bookId: 'booklist'}, isArray:true}
  });
});