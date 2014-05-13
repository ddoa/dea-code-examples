forumplugin.controller('ForumController', ['$scope', '$forumService', function ForumController($scope, $forumService) {
    $scope.formData = {}

    $forumService.getForums(function (forumModel) {
        $scope.forums = forumModel;
    });

    $forumService.getCurrentUser(function (currentUser) {
        $scope.currentUser = currentUser;
    });

    $scope.clearMessages = function () {
        AJS.$("#aui-message-bar").empty();
    }

    $scope.deleteForum = function (forumId) {
        $forumService.deleteForum(forumId, function (forumModel) {
            $scope.forums = forumModel;
            $scope.clearMessages();
            AJS.messages.success("#aui-message-bar", {
                body: "<p>Forum deleted successfully.</p>",
                closeable: true,
                shadowed: true
            });

        });
    }

    $scope.saveForum = function () {
        $forumService.saveForum($scope.formData.title, function(forumModel)
        {
            $scope.forums = forumModel;
            $scope.clearMessages();
            AJS.messages.success("#aui-message-bar", {
                title: "New forum created successfully.",
                body: "<p>" + $scope.formData.title + "</p>",
                closeable: true,
                shadowed: true
            });
        });
    };
}]);