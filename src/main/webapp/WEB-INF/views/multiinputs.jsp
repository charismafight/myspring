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
    myapp.directive("multiInput", function () {
        return {
            restrict: "E",
            template: "<input value=\"{{text}}\">",
            link: function (scope, element, attrs) {
                attrs.$observe('id', function (value) {
                    console.log(value);
                    scope.text = scope.$eval(value);
                })
            }
        };
    })
</script>
<div ng-app="myapp">
    <multi-input id="fuck"></multi-input>
</div>
