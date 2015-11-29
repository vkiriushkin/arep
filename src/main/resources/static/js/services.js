'use strict';

/* Services */

var autoServices = angular.module('autoServices', ['ngResource']);

autoServices.factory('Mark', ['$resource',
    function ($resource) {
        return $resource('/marks', {}, {
            getMarks: {method: 'GET', isArray: true}
        });
    }]);