var spark = angular.module('spark', [])
spark.controller('categoriesController', function ($scope) {
  $scope.categories = [
    {
      cat_id: 1,
      cat_name: 'Agriculture'
      },
    {
      cat_id: 2,
      cat_name: 'Energy'
      },
    {
      cat_id: 3,
      cat_name: 'Health'
      },
    {
      cat_id: 4,
      cat_name: 'Jobs'
      },
    {
      cat_id: 5,
      cat_name: 'IT'
      },
    {
      cat_id: 6,
      cat_name: 'Health'
      }
    ];
  
  $scope.addCategory = function($scope){
    categories.push({cat_id: 8,
      cat_name: 'New'});
  };
});