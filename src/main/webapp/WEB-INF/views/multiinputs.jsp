<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 18-5-15
  Time: 下午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="http://cdn.static.runoob.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script>
    var myapp = angular.module('myapp', []);
    myapp.controller("ctl", function ($scope) {
        $scope.inputvalue = "xxx";
    })
    myapp.directive("multiInput", function () {
        return {
            restrict: "E",
            template: "<input value=\"{{content}}\">",
            link: function (scope, element, attrs) {
                attrs.$observe('id', function (value) {
                    console.log(value);
                    scope.content = scope.$eval(value);
                })
            }
        };
    })
</script>
<div ng-app="myapp" ng-controller="ctl">
    <multi-input id="inputvalue"></multi-input>
</div>
