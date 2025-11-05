package com.chjcfcaloc2020.my_blog.mapper;

import com.chjcfcaloc2020.my_blog.common.PostStatus;
import com.chjcfcaloc2020.my_blog.dto.CategoryDto;
import com.chjcfcaloc2020.my_blog.dto.request.CreateCategoryRequest;
import com.chjcfcaloc2020.my_blog.model.Category;
import com.chjcfcaloc2020.my_blog.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostCount")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest request);

    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (null == posts) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
