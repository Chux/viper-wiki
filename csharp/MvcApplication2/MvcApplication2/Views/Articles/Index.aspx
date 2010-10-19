<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<MvcApplication2.Models.Article>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	<%: ViewData["ArticleTitle"] %>
</asp:Content>

<<<<<<< HEAD
<asp:Content ID="Content3" ContentPlaceHolderID="MainHeaderContent" runat="server">
	<%: ViewData["ArticleTitle"] %>
</asp:Content>
=======
<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>Index</h2>

    <table>
        <tr>
            <th></th>
            <th>
                id
            </th>
            <th>
                title
            </th>
            <th>
                content
            </th>
        </tr>

    <% foreach (var item in Model) { %>
    
        <tr>
            <td>
                <%: Html.ActionLink("Edit", "Edit", new { id=item.id }) %> |
                <%: Html.ActionLink("Details", "Details", new { id=item.id })%> |
                <%: Html.ActionLink("Delete", "Delete", new { id=item.id })%>
            </td>
            <td>
                <%: item.id %>
            </td>
            <td>
                <%: item.title %>
            </td>
            <td>
                <%: item.content %>
            </td>
        </tr>
    
    <% } %>
>>>>>>> 4c62ee1c04b8b68fd9d12d512ad0ee2e818bde38

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">
    <%: ViewData["ArticleContent"] %>
</asp:Content>

<asp:Content ID="Content4" ContentPlaceHolderID="ArticleMenuContent" runat="server">
</asp:Content>

<<<<<<< HEAD
=======
    <p>
        <%: Html.ActionLink("See all articles", "Articles") %>
    </p>

    <form action="Articles/Search" method = "post">
        <label>Search: </label>
        <input type = "text" name = "search_article" />
        <input type = "submit" />
    </form>

</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="LoginMenuContent" runat="server">
</asp:Content>

<asp:Content ID="Content4" ContentPlaceHolderID="ArticleMenuContent" runat="server">
</asp:Content>

<asp:Content ID="Content5" ContentPlaceHolderID="MainHeaderContent" runat="server">
</asp:Content>

>>>>>>> 4c62ee1c04b8b68fd9d12d512ad0ee2e818bde38
<asp:Content ID="Content6" ContentPlaceHolderID="FooterContent" runat="server">
</asp:Content>

