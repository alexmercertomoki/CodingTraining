from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
    url(r'^$', 'private.views.home'),
    url(r'^add-item', 'private.views.add_item'),
    url(r'^delete-item', 'private.views.delete_item'),
    url(r'^delete-all', 'private.views.delete_all'),
)
