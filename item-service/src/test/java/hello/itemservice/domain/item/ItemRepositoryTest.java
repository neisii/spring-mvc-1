package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ItemRepositoryTest {

    private final ItemRepository itemRepository = new ItemRepository();
    private Item updateParam;

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @DisplayName("save")
    @Test
    void save() {
      // given
      Item item = new Item("itemA", 10000, 10);
      // when
        Item savedItem = itemRepository.save(item);

      // then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem).isEqualTo(savedItem);
    }

    @DisplayName("findAll")
    @Test
    void findAll() {
      // given
      Item item = new Item("itemA", 10000, 10);
      Item item2 = new Item("itemB", 20000, 20);

      // when
        itemRepository.save(item);
        itemRepository.save(item2);

      // then
        List<Item> result = itemRepository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }

    @DisplayName("")
    @Test
    void updateItem() {
        // given
        Item item = new Item("itemA", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        // when
        updateParam = new Item("itemB", 20000, 30);
        itemRepository.update(itemId, updateParam);

        // then
        Item findItem = itemRepository.findById(item.getId());
        Assertions.assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        Assertions.assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        Assertions.assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());

    }

}