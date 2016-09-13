from django.http import HttpResponse
from django.shortcuts import render


def home_page(request):
    # render takes: (1) the request,
    #               (2) the name of the view to generate, and
    #               (3) a dictionary of name-value pairs of data to be
    #                   available to the view.
    return render(request, 'intro/index.html', {})

def hello_world(request):
    # Just return an HttpResponse object with the HTML we want to send
    html="""
        <!DOCTYPE HTML>
        <html>
          <head>
              <meta charset="utf-8">
              <title>Hello World</title>
          </head>
          <body>
              <h1>Hello World!  bitch</h1>
          </body>
        </html>
    """
    return HttpResponse(html)


def hello_world_with_template(request):
    # render takes: (1) the request,
    #               (2) the name of the view to generate, and
    #               (3) a dictionary of name-value pairs of data to be
    #                   available to the view.
    return render(request, 'intro/hello-world.html', {})


# The action for the 'intro/hello.html' route.
def greet(request):
    # Creates a context dictionary (map) to send data to the templated HTML file
    context = {}

    # Retrieve the 'name' parameter, if present, and add it to the context
    if 'name' in request.GET:
        context['person_name'] = request.GET['name']

    # Pass the context to the templated HTML file (aka the "view")
    return render(request, 'intro/greet.html', context)
