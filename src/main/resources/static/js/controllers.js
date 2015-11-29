'use strict';

/* Controllers */

var autoControllers = angular.module('autoControllers', []);

autoControllers.controller('MarksCtrl', ['$scope', 'Mark',

  function($scope, Mark) {

      $scope.marks = Mark.getMarks();
  }]);