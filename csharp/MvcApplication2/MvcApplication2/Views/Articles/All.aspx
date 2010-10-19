<%@ Page Title="" Language="C#" MasterPageFile="~/Views/Shared/Site.Master" Inherits="System.Web.Mvc.ViewPage<IEnumerable<MvcApplication2.Models.Article>>" %>

<asp:Content ID="Content1" ContentPlaceHolderID="TitleContent" runat="server">
	All
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="MainContent" runat="server">

    <h2>All</h2>

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

    </table>

    <p>
        <%: Html.ActionLink("Create New", "Create") %>
    </p>

</asp:Content>

