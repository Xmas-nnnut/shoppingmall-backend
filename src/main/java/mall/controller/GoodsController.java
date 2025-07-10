package mall.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mall.model.Goods;
import mall.service.GoodsService;
import mall.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "2-商品接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation("分页获取商品首页列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "当前页数量",dataTypeClass = Integer.class,required = true,defaultValue = "4"),
    })
    @GetMapping("/all")
    public Result getAllgoods(@RequestParam(name = "pageNum") Integer pageNum,
                              @RequestParam(name = "pageSize") Integer pageSize)
    {
        PageInfo<Goods> pageInfo = goodsService.getAllgoods(pageNum,pageSize);
        return Result.success(pageInfo);
    }

    @ApiOperation("根据商品id获取商品详情")
    @ApiImplicitParam(name = "gid",value = "商品id",dataTypeClass = String.class,required = true,defaultValue = "1")
    @GetMapping("/detail/{gid}")
    public Result detail( @PathVariable(name = "gid")Integer gid)
    {
        Goods goods = goodsService.getGoodById(gid);
        return Result.success(goods);
    }

    @ApiOperation("根据商品分类(types)，分页获取商品首页列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "types",value = "商品分类",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "当前页数量",dataTypeClass = Integer.class,required = true,defaultValue = "4"),
    })
    @GetMapping("/types")
    public Result getGoodsByTypes(@RequestParam(name = "types") Integer types,
                                  @RequestParam(name = "pageNum") Integer pageNum,
                                  @RequestParam(name = "pageSize") Integer pageSize)
    {
        PageInfo<Goods> pageInfo = goodsService.getGoodsByTypes(types,pageNum,pageSize);
        return Result.success(pageInfo);
    }
    
    @ApiOperation("商品首页搜索-根据名称模糊查找商品")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "gname",value = "商品名称",dataTypeClass = String.class,required = true,defaultValue = "水果"),
            @ApiImplicitParam(name = "pageNum",value = "当前页码",dataTypeClass = Integer.class,required = true,defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "当前页数量",dataTypeClass = Integer.class,required = true,defaultValue = "4"),
    })
    @GetMapping("/search")
    public Result search( @RequestParam(name = "gname") String gname,
                          @RequestParam(name = "pageNum") Integer pageNum,
                          @RequestParam(name = "pageSize") Integer pageSize)
    {
        PageInfo<Goods> pageInfo = goodsService.searchGoodsByName(gname,pageNum,pageSize);
        return Result.success(pageInfo);
    }
}
