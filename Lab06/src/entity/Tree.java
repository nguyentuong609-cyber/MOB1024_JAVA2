package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tree {
	private Integer node_id;
	private String node_name;
	private Integer parent_id;
	private Integer level;
}
	