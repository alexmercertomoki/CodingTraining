from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
    url(r'^$', 'private.views.home'),
    url(r'^add-item', 'private.views.add_item'),
    url(r'^delete-item/(?P<id>\d+)$', 'private.views.delete_item'),
    # Route for built-in authentication with our own custom login page
    url(r'^login$', 'django.contrib.auth.views.login', {'template_name':'private/login.html'}),
    # Route to logout a user and send them back to the login page
    url(r'^logout$', 'django.contrib.auth.views.logout_then_login'),
    url(r'^register$', 'private.views.register'),
)

