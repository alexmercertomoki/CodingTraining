from django.conf.urls import patterns, include, url

urlpatterns = patterns('',
    url(r'^$', 'shared.views.home'),
    url(r'^add-item', 'shared.views.add_item'),
    url(r'^delete-item', 'shared.views.delete_item'),
)
