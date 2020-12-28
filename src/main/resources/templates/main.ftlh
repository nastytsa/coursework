<#import "parts/common.ftlh" as c>

<@c.page>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Create new order
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="text" placeholder="Enter description" />
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group">
                    <button type="submit" class="btn btn-primary" >Submit</button>
                </div>

            </form>
        </div>
    </div>

    <div class="card-columns">
        <#list orders as order>
            <div class="card my-3">
                <div class="m-2">
                    <span>${order.text}</span>
                </div>
                <div class="card-footer text-muted">
                    ${order.customerName}
                </div>
            </div>
        <#else>
            No orders
        </#list>
    </div>
</@c.page>