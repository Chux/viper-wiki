<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<MvcApplication2.Models.Article>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	<%: ViewData["ArticleTitle"] %>
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="MainHeaderContent" runat="server">
	<%: ViewData["ArticleTitle"] %>
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <%= ViewData["ArticleContent"] %>
</asp:Content>

<asp:Content ID="Content4" ContentPlaceHolderID="ArticleMenuContent" runat="server">
</asp:Content>

<asp:Content ID="Content6" ContentPlaceHolderID="FooterContent" runat="server">
</asp:Content>

