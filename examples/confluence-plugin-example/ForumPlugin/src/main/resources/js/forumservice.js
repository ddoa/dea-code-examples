forumplugin.service('$forumService', ['$http', function ($http) {
    var RESTAPI = AJS.contextPath() + '/rest/forum/latest/threads';

    this.getCurrentUser = function (callback) {
        $http.get(AJS.contextPath() + '/rest/gadget/1.0/currentUser').success(function (data) {
            if (data) {
                callback(data.username);
            }
        });
    }

    this.getForums = function (callback) {
        $http.get(RESTAPI).success(function (data) {
            if (data) {
                callback(data);
            }
        });
    };

    this.saveForum = function (forum, callback) {
        // Preserve the this pointer so we can refer to the service from within the callback-function.
        var that = this;
        $http.post(RESTAPI, forum).success(function () {
            that.getForums(callback);
        });
    }

    this.deleteForum = function (forumId, callback) {
        // Preserve the this pointer so we can refer to the service from within the callback-function.
        var that = this;
        $http({method: 'DELETE', url: RESTAPI + forumId}).success(function (data) {
            that.getForums(callback);
        });
    };
}]);