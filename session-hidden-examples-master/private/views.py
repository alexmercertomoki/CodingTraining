from django.shortcuts import render
from threading import Lock

def home(request):
    if not 'list' in request.session:
        request.session['list'] = []

    context = {'items':request.session['list']}
    return render(request, 'private/index.html', context)


def add_item(request):
    errors = []  # A list to record messages for any errors we encounter.

    if not 'list' in request.session:
        request.session['list'] = []
    list = request.session['list']

    # Adds the new item to the list if the request parameter is present
    if not 'item' in request.POST or not request.POST['item']:
        errors.append('You must enter an item to add.')
    else:
        list.append(request.POST['item'])
        request.session.modified = True

    context = {'items':list, 'errors':errors}
    return render(request, 'private/index.html', context)

def delete_item(request):
    errors = []

    if not 'list' in request.session:
        request.session['list'] = []
    list = request.session['list']

    if not 'item' in request.GET:
        errors.append('Missing parameter: item')
    else:
        item = request.GET['item']
        try:
            list.remove(item)
            request.session.modified = True
        except ValueError:
            errors.append('This item is not on the list: ' + item)

    context = {'items':list, 'errors':errors}
    return render(request, 'private/index.html', context)


def delete_all(request):
    errors = []
    request.session['list'] = []
    context = {'items':list, 'errors':errors}
    return render(request, 'private/index.html', context)
