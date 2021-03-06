﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace MvcApplication2
{
    // Note: For instructions on enabling IIS6 or IIS7 classic mode, 
    // visit http://go.microsoft.com/?LinkId=9394801

    public class MvcApplication : System.Web.HttpApplication
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");


            routes.MapRoute(
                "Articles", // Route name
                "Articles/All", // URL with parameters
                new { controller = "Articles", action = "All" } // Parameter defaults
            );

            routes.MapRoute(
                "Articles/Search", // Route name
                "Articles/Search", // URL with parameters
                new { controller = "Articles", action = "Search" } // Parameter defaults
            );

            routes.MapRoute(
              "Articles/All", // Route name
              "Articles/{articletitle}", // URL with parameters
              new { controller = "Articles", action = "Index" } // Parameter defaults
            );

            routes.MapRoute(
                "Default", // Route name
                "{controller}/{action}/{id}", // URL with parameters
                new { controller = "Home", action = "Index", id = UrlParameter.Optional } // Parameter defaults
            );

        }

        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();

            RegisterRoutes(RouteTable.Routes);
        }
    }
}